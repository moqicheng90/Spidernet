package com.wits.mqc.shixin.dao;

import java.util.List;
import java.util.Map;

import com.wits.mqc.shixin.entity.LegalLost;

public interface LegalLostDao {
	
	/**
	 * �����ݲ����cust_lg_lost
	 * @param legalLost
	 */
	void insertLegalLost(LegalLost legalLost);
	
	/**
	 * ����did��ѯcust_lg_lost�еļ�¼
	 * @param did
	 * @return
	 */
	LegalLost queryLegalLost(Integer did);
	
	/**
	 * ģ����ѯʧ�����б�
	 * @param iname
	 * @return
	 */
	List<LegalLost> queryLegalLostList(Map<String,Object> map);
	
	/**
	 * ģ����ѯʧ��������
	 * @param iname
	 * @return
	 */
	Integer queryLegalLostListSize(String iname);

}
