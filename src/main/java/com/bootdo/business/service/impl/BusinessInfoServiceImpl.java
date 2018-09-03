package com.bootdo.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.business.dao.BusinessInfoDao;
import com.bootdo.business.domain.BusinessInfoDO;
import com.bootdo.business.service.BusinessInfoService;



@Service
public class BusinessInfoServiceImpl implements BusinessInfoService {
	@Autowired
	private BusinessInfoDao businessInfoDao;
	
	@Override
	public BusinessInfoDO get(Integer id){
		return businessInfoDao.get(id);
	}
	
	@Override
	public List<BusinessInfoDO> list(Map<String, Object> map){
		return businessInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return businessInfoDao.count(map);
	}
	
	@Override
	public int save(BusinessInfoDO businessInfo){
		businessInfo.setCreateTime(new Date());
		businessInfo.setUpdateTime(new Date());
		return businessInfoDao.save(businessInfo);
	}
	
	@Override
	public int update(BusinessInfoDO businessInfo){
		businessInfo.setUpdateTime(new Date());
		return businessInfoDao.update(businessInfo);
	}
	
	@Override
	public int remove(Integer id){
		return businessInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return businessInfoDao.batchRemove(ids);
	}
	
}
