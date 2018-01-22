package com.wits.mqc.shixin.service;

import java.util.Map;

public interface ShixinService {
	
	/**
	 * 访问主页面时首次获得验证码
	 * @param path_prj
	 * @return
	 */
	Map<String,String> getImage(String path_prj);
	
	/**
	 * 刷新验证码
	 * @param path_prj
	 * @param captchaId
	 */
	void refreshImage(String path_prj,String captchaId);
	
	/**
	 * 查询获得失信人列表
	 * @param map
	 * @return
	 */
	String ShixinDataList(Map<String,String> map);
	
	/**
	 * 查询本地数据库失信人列表
	 * @param iname
	 * @param currentPage
	 * @return
	 */
	String ShixinDataListLocal(String iname,String currentPage);
	
	/**
	 * 查询失信详情
	 * @param id
	 * @param pCode
	 * @param captchaId
	 * @return
	 */
	String ShixinDetail(String id, String pCode, String captchaId);
}
