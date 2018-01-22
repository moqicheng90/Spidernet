package com.wits.mqc.entinfo.service;

import com.wits.mqc.entinfo.entity.EntInfo;

public interface EntInfoService {
	
	/**
	 * 根据企业名称查询企业基本信息
	 * @param entName
	 * @return
	 */
	EntInfo queryEntInfo(String entName);

}
