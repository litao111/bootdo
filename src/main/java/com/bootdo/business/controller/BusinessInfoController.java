package com.bootdo.business.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import com.bootdo.common.config.BusinessConfig;
import com.bootdo.common.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.business.domain.BusinessInfoDO;
import com.bootdo.business.service.BusinessInfoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-10 10:09:09
 */

@Controller
@RequestMapping("/business/businessInfo")
public class BusinessInfoController {
    @Autowired
    private BusinessInfoService businessInfoService;
    @Autowired
    private BusinessConfig businessConfig;

    @GetMapping()
    @RequiresPermissions("business:businessInfo:businessInfo")
    String BusinessInfo() {
        return "business/businessInfo/businessInfo";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("business:businessInfo:businessInfo")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<BusinessInfoDO> businessInfoList = businessInfoService.list(query);
        int total = businessInfoService.count(query);
        PageUtils pageUtils = new PageUtils(businessInfoList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/consumeLevel")
    public JsonResult consumeLevel() {
        //查询列表数据
        List<Map<String, Object>> dictConsumeLevels = new ArrayList<>();
        String[] array = businessConfig.getConsume_level().split(";");
        for (int i = 0; i < array.length; i++) {
            String[] array2 = array[i].split(":");
            Map<String, Object> map = new HashMap<>();
            map.put("key", array2[0]);
            map.put("value", array2[1]);
            dictConsumeLevels.add(map);
        }
        return new JsonResult.JsonResultBuilder().state(0).message("成功").data(dictConsumeLevels).build();
    }

    @ResponseBody
    @GetMapping("/numbersLevel")
    public JsonResult numbersLevel() {
        //查询列表数据
        List<Map<String, Object>> dictnumberLevels = new ArrayList<>();
        String[] array = businessConfig.getNumber_level().split(";");
        for (int i = 0; i < array.length; i++) {
            String[] array2 = array[i].split(":");
            Map<String, Object> map = new HashMap<>();
            map.put("key", array2[0]);
            map.put("value", array2[1]);
            dictnumberLevels.add(map);
        }
        return new JsonResult.JsonResultBuilder().state(0).message("成功").data(dictnumberLevels).build();
    }

    @ResponseBody
    @GetMapping("/addressType")
    public JsonResult addressType() {
        //查询列表数据
        List<Map<String, Object>> dictAddressTypes = new ArrayList<>();
        String[] array = businessConfig.getAddress_type().split(";");
        for (int i = 0; i < array.length; i++) {
            String[] array2 = array[i].split(":");
            Map<String, Object> map = new HashMap<>();
            map.put("key", array2[0]);
            map.put("value", array2[1]);
            dictAddressTypes.add(map);
        }
        return new JsonResult.JsonResultBuilder().state(0).message("成功").data(dictAddressTypes).build();
    }

    @ResponseBody
    @GetMapping("/test1")
    public void test(HttpServletRequest request) {
        String servePath = request.getServletContext().getRealPath("/");
        System.out.println("---------------------------------"+servePath);
    }

    @GetMapping("/add")
    @RequiresPermissions("business:businessInfo:add")
    String add() {
        return "business/businessInfo/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("business:businessInfo:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        BusinessInfoDO businessInfo = businessInfoService.get(id);
        model.addAttribute("businessInfo", businessInfo);
        return "business/businessInfo/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("business:businessInfo:add")
    public R save(BusinessInfoDO businessInfo, HttpServletRequest request,MultipartHttpServletRequest mreq) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1、设置临时上传的路径
//        DiskFileItemFactory disk = new DiskFileItemFactory(10240, new File("e:disk"));
        StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
        Iterator<String> iterator = req.getFileNames();
        while (iterator.hasNext()) {
            MultipartFile file = mreq.getFile(iterator.next());
            //获取上传文件的名字
            String fileName = file.getOriginalFilename();
            fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
            //获取上传文件的后缀
            String extName = fileName.substring(fileName.lastIndexOf("."));
            //申明UUID
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //组成新的名称
            String newName = uuid + extName;
            //2、设置文件上传的目标路径
            String servePath = businessConfig.getUploadPath();
            File source = new File(servePath + "/" + newName);
            /*if(!source.getParentFile().exists()){
                source.getParentFile().createNewFile();
            }*/
            file.transferTo(source);
            businessInfo.setHeaderImg(newName);
        }
        if (businessInfoService.save(businessInfo) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     *
     * @param imageName
     * @param response
     * @throws IOException
     */
    @PostMapping("/showImage")
    public void showImage(String imageName,HttpServletResponse response) throws IOException{
        String servePath = businessConfig.getUploadPath();
        ServletOutputStream out = null;
        //获取图片路径
        String filePath=servePath+ "/"+imageName;
        //读取本地图片输入流
        FileInputStream ips = new FileInputStream(filePath);
        response.setContentType("multipart/form-data");
        out = response.getOutputStream();
        //读取文件流
        int len = 0;
        byte[] buffer = new byte[1024 * 10];
        while ((len = ips.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        out.flush();
        out.close();
        ips.close();
        /*方式二：
        int i = inputStream.available();
        //byte数组用于存放图片字节数据
        byte[] buff = new byte[i];
        inputStream.read(buff);
        //记得关闭输入流
        inputStream.close();
        //设置发送到客户端的响应内容类型
        response.setContentType("image*//*");
        OutputStream out = response.getOutputStream();
        out.write(buff);
        //关闭响应输出流
        out.close();*/
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("business:businessInfo:edit")
    public R update(BusinessInfoDO businessInfo) {
        businessInfoService.update(businessInfo);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("business:businessInfo:remove")
    public R remove(Integer id) {
        if (businessInfoService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("business:businessInfo:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        businessInfoService.batchRemove(ids);
        return R.ok();
    }

}
