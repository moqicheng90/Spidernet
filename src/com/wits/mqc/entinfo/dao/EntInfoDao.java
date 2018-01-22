package com.wits.mqc.entinfo.dao;

import java.util.List;
import com.wits.mqc.entinfo.entity.ChangeRecord;
import com.wits.mqc.entinfo.entity.EntBasicInfo;
import com.wits.mqc.entinfo.entity.ShareHolderInfo;

public interface EntInfoDao {
	
	/**
	 * 根据企业名称精确查找本地数据库企业基本信息
	 * @param entName
	 * @return
	 */
	EntBasicInfo queryEntBasicInfo(String entName);
	
	/**
	 * 根据企业id查询工商变更记录
	 * @param entID
	 * @return
	 */
	List<ChangeRecord> queryChangeRecordsByEntID(Integer entID);
	
	/**
	 * 根据企业id查询股东出资信息
	 * @param entID
	 * @return
	 */
	List<ShareHolderInfo> queryShareHolderInfosByEntID(Integer entID);
	
	/**
	 * 本地数据库表ent_basic_info中插入企业基本数据
	 * @param info
	 */
	void insertEntBasicInfo(EntBasicInfo info);
	
	/**
	 * 插入本地数据库表ent_change_records
	 * @param record
	 */
	void insertChangeRecord(ChangeRecord record);
	
	/**
	 * 插入本地数据库表ent_shareholder_info
	 * @param shareHolderInfo
	 */
	void insertShareHolderInfo(ShareHolderInfo shareHolderInfo);

}
