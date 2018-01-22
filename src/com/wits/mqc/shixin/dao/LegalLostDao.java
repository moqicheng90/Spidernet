package com.wits.mqc.shixin.dao;

import java.util.List;
import java.util.Map;

import com.wits.mqc.shixin.entity.LegalLost;

public interface LegalLostDao {
	
	/**
	 * 将数据插入表cust_lg_lost
	 * @param legalLost
	 */
	void insertLegalLost(LegalLost legalLost);
	
	/**
	 * 根据did查询cust_lg_lost中的记录
	 * @param did
	 * @return
	 */
	LegalLost queryLegalLost(Integer did);
	
	/**
	 * 模糊查询失信人列表
	 * @param iname
	 * @return
	 */
	List<LegalLost> queryLegalLostList(Map<String,Object> map);
	
	/**
	 * 模糊查询失信人总数
	 * @param iname
	 * @return
	 */
	Integer queryLegalLostListSize(String iname);

}
