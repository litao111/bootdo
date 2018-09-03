package com.bootdo.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-10 10:09:09
 */
public class BusinessInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//店名
	private String name;
	//老板名字
	private String bossName;
	//老板电话
	private String bossPhone;
	//地址全称
	private String address;
	//城市
	private String city;
	//区
	private String country;
	//街道
	private String street;
	//详细地址
	private String detail;
	//桌数
	private Integer desks;
	//消费等级0：一般1：中等2：高档
	private Integer consumeLevel;
	//流量等级0：一般1：中等2：较多3：很多
	private Integer numbersLevel;
	//剩余桌数
	private Integer leftDesks;
	//已发布广告桌位数
	private Integer publishDesks;
	//创建时间
	private Date createTime;
	//合同开始时间
	private Date startTime;
	//合同终止时间
	private Date endTime;
	//店的类型描述
	private String type;
	//地理位置描述：1：商务2：小学3：中学4：大学5：CBD6：旅游景点7：居民社区
	private String addressType;
	//0：正常-1：删除
	private Integer status;
	//价格/桌/天
	private String price;
	//门店的图片名称
	private String headerImg;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：店名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：店名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：老板名字
	 */
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	/**
	 * 获取：老板名字
	 */
	public String getBossName() {
		return bossName;
	}
	/**
	 * 设置：老板电话
	 */
	public void setBossPhone(String bossPhone) {
		this.bossPhone = bossPhone;
	}
	/**
	 * 获取：老板电话
	 */
	public String getBossPhone() {
		return bossPhone;
	}
	/**
	 * 设置：地址全称
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址全称
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：区
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：区
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：街道
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * 获取：街道
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * 设置：详细地址
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：详细地址
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：桌数
	 */
	public void setDesks(Integer desks) {
		this.desks = desks;
	}
	/**
	 * 获取：桌数
	 */
	public Integer getDesks() {
		return desks;
	}
	/**
	 * 设置：消费等级0：一般1：中等2：高档
	 */
	public void setConsumeLevel(Integer consumeLevel) {
		this.consumeLevel = consumeLevel;
	}
	/**
	 * 获取：消费等级0：一般1：中等2：高档
	 */
	public Integer getConsumeLevel() {
		return consumeLevel;
	}
	/**
	 * 设置：流量等级0：一般1：中等2：较多3：很多
	 */
	public void setNumbersLevel(Integer numbersLevel) {
		this.numbersLevel = numbersLevel;
	}
	/**
	 * 获取：流量等级0：一般1：中等2：较多3：很多
	 */
	public Integer getNumbersLevel() {
		return numbersLevel;
	}
	/**
	 * 设置：剩余桌数
	 */
	public void setLeftDesks(Integer leftDesks) {
		this.leftDesks = leftDesks;
	}
	/**
	 * 获取：剩余桌数
	 */
	public Integer getLeftDesks() {
		return leftDesks;
	}
	/**
	 * 设置：已发布广告桌位数
	 */
	public void setPublishDesks(Integer publishDesks) {
		this.publishDesks = publishDesks;
	}
	/**
	 * 获取：已发布广告桌位数
	 */
	public Integer getPublishDesks() {
		return publishDesks;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：合同开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：合同开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：合同终止时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：合同终止时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：店的类型描述
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：店的类型描述
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：地理位置描述：1：商务2：小学3：中学4：大学5：CBD6：旅游景点7：居民社区
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	/**
	 * 获取：地理位置描述：1：商务2：小学3：中学4：大学5：CBD6：旅游景点7：居民社区
	 */
	public String getAddressType() {
		return addressType;
	}
	/**
	 * 设置：0：正常-1：删除
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0：正常-1：删除
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：价格/桌/天
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：价格/桌/天
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：门店的图片名称
	 */
	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg;
	}
	/**
	 * 获取：门店的图片名称
	 */
	public String getHeaderImg() {
		return headerImg;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
