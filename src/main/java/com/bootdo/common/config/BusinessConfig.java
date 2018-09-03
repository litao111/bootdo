package com.bootdo.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hasee on 2018/8/13.
 */
@Component
@ConfigurationProperties(prefix="business")
public class BusinessConfig {
    //上传路径
    private String uploadPath;
    //消费等级
    private String number_level;
    //流量等级
    private String consume_level;
    //地理位置描述
    private String address_type;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getNumber_level() {
        return number_level;
    }

    public void setNumber_level(String number_level) {
        this.number_level = number_level;
    }

    public String getConsume_level() {
        return consume_level;
    }

    public void setConsume_level(String consume_level) {
        this.consume_level = consume_level;
    }

    public String getAddress_type() {
        return address_type;
    }

    public void setAddress_type(String address_type) {
        this.address_type = address_type;
    }
}
