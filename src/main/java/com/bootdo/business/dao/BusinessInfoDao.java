package com.bootdo.business.dao;

import com.bootdo.business.domain.BusinessInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-10 10:09:09
 */
@Mapper
public interface BusinessInfoDao {

	BusinessInfoDO get(Integer id);
	
	List<BusinessInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BusinessInfoDO businessInfo);
	
	int update(BusinessInfoDO businessInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
