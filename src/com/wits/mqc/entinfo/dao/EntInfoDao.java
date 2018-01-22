package com.wits.mqc.entinfo.dao;

import java.util.List;
import com.wits.mqc.entinfo.entity.ChangeRecord;
import com.wits.mqc.entinfo.entity.EntBasicInfo;
import com.wits.mqc.entinfo.entity.ShareHolderInfo;

public interface EntInfoDao {
	
	/**
	 * ������ҵ���ƾ�ȷ���ұ������ݿ���ҵ������Ϣ
	 * @param entName
	 * @return
	 */
	EntBasicInfo queryEntBasicInfo(String entName);
	
	/**
	 * ������ҵid��ѯ���̱����¼
	 * @param entID
	 * @return
	 */
	List<ChangeRecord> queryChangeRecordsByEntID(Integer entID);
	
	/**
	 * ������ҵid��ѯ�ɶ�������Ϣ
	 * @param entID
	 * @return
	 */
	List<ShareHolderInfo> queryShareHolderInfosByEntID(Integer entID);
	
	/**
	 * �������ݿ��ent_basic_info�в�����ҵ��������
	 * @param info
	 */
	void insertEntBasicInfo(EntBasicInfo info);
	
	/**
	 * ���뱾�����ݿ��ent_change_records
	 * @param record
	 */
	void insertChangeRecord(ChangeRecord record);
	
	/**
	 * ���뱾�����ݿ��ent_shareholder_info
	 * @param shareHolderInfo
	 */
	void insertShareHolderInfo(ShareHolderInfo shareHolderInfo);

}
