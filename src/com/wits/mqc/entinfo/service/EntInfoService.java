package com.wits.mqc.entinfo.service;

import com.wits.mqc.entinfo.entity.EntInfo;

public interface EntInfoService {
	
	/**
	 * ������ҵ���Ʋ�ѯ��ҵ������Ϣ
	 * @param entName
	 * @return
	 */
	EntInfo queryEntInfo(String entName);

}
