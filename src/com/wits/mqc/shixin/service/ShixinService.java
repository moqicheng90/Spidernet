package com.wits.mqc.shixin.service;

import java.util.Map;

public interface ShixinService {
	
	/**
	 * ������ҳ��ʱ�״λ����֤��
	 * @param path_prj
	 * @return
	 */
	Map<String,String> getImage(String path_prj);
	
	/**
	 * ˢ����֤��
	 * @param path_prj
	 * @param captchaId
	 */
	void refreshImage(String path_prj,String captchaId);
	
	/**
	 * ��ѯ���ʧ�����б�
	 * @param map
	 * @return
	 */
	String ShixinDataList(Map<String,String> map);
	
	/**
	 * ��ѯ�������ݿ�ʧ�����б�
	 * @param iname
	 * @param currentPage
	 * @return
	 */
	String ShixinDataListLocal(String iname,String currentPage);
	
	/**
	 * ��ѯʧ������
	 * @param id
	 * @param pCode
	 * @param captchaId
	 * @return
	 */
	String ShixinDetail(String id, String pCode, String captchaId);
}
