package com.wits.mqc.shixin.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wits.mqc.shixin.dao.LegalLostDao;
import com.wits.mqc.shixin.entity.LegalLost;
import com.wits.mqc.shixin.service.ShixinService;
import com.wits.spider.shixin.service.ShiXinServiceImpl;
@Service("shixinService")
public class ShixinServiceImpl implements ShixinService{
	
	public ShiXinServiceImpl query = new ShiXinServiceImpl();
	
	@Autowired
	private LegalLostDao legalLostDao;

	public Map<String,String> getImage(String path_prj){
		
		Map<String,Object> result = query.getCaptchaImage();
		Map<String,String> resultBak = new HashMap<String,String>();
		String captchaId = (String) result.get("captchaId");
		byte[] bytes = (byte[]) result.get("img"); 
		File file = new File(path_prj+"/img");
		if(file.exists()){
			file.deleteOnExit();
		}
		file.mkdir();
		File img = new File(path_prj+"/img/1.png");
		try {
			img.createNewFile();
			FileOutputStream output = new FileOutputStream(img);  
			output.write(bytes);  
			output.close();
			resultBak.put("captchaId", captchaId);
			resultBak.put("path", img.getCanonicalPath());
			return resultBak;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	/**
	 * 刷新验证码
	 * @param path_prj
	 * @param captchaId
	 */
	public void refreshImage(String path_prj,String captchaId){
		
		byte[] bytes = query.refreshCaptchaImg(captchaId);
		File file = new File(path_prj+"/img");
		if(file.exists()){
			file.deleteOnExit();
		}
		file.mkdir();
		File img = new File(path_prj+"/img/1.png");
		try {
			img.createNewFile();
			FileOutputStream output = new FileOutputStream(img);  
			output.write(bytes);  
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 爬虫接口返回失信人列表
	 */
	public String ShixinDataList(Map<String,String> map){
		String result = query.getShiXinData(map);
		if("error".equals(result)){
			return "{\"err\":\"error\"}";
		}
		else{
			return result;
		}
	}
	
	
	/**
	 * 失信人详情(若本地数据库有数据，则从本地数据库查询，否则从爬虫接口查询)
	 */
	public String ShixinDetail(String did, String pCode, String captchaId){
		
		LegalLost lgLost = legalLostDao.queryLegalLost(Integer.valueOf(did));
		
		if(null == lgLost){
			String str = query.queryShiXinDetail(did, pCode, captchaId);
			JSONObject json = JSONObject.fromObject(str);
			if(!json.isEmpty()){
				LegalLost legalLost = new LegalLost();
				legalLost.setDid(Integer.valueOf(did));
				legalLost.setLgChkId("");
				if(json.has("iname")){
					legalLost.setIname(json.getString("iname"));
				}
				if(json.has("caseCode")){
					legalLost.setCaseCode(json.getString("caseCode"));
				}
				if(json.has("age")){
					legalLost.setAge(json.getString("age"));
				}
				if(json.has("sexy")){
					legalLost.setSexy(json.getString("sexy"));
				}
				if(json.has("cardNum")){
					legalLost.setCardNum(json.getString("cardNum"));
				}
				if(json.has("courtName")){
					legalLost.setCourtName(json.getString("courtName"));
				}
				if(json.has("areaName")){
					legalLost.setAreaName(json.getString("areaName"));
				}
				if(json.has("businessEntity")){
					legalLost.setBusinessEntity(json.getString("businessEntity"));
				}
				if(json.has("partyTypeName")){
					legalLost.setPartyTypeName(json.getString("partyTypeName"));
				}
				if(json.has("gistId")){
					legalLost.setGistId(json.getString("gistId"));
				}
				if(json.has("regDate")){
					legalLost.setRegDate(json.getString("regDate"));
				}
				if(json.has("gistUnit")){
					legalLost.setGistUnit(json.getString("gistUnit"));
				}
				if(json.has("duty")){
					legalLost.setDuty(json.getString("duty"));
				}
				if(json.has("performance")){
					legalLost.setPerformance(json.getString("performance"));
				}
				if(json.has("performedPart")){
					legalLost.setPerformedPart(json.getString("performedPart"));
				}
				if(json.has("unperformPart")){
					legalLost.setUnperformPart(json.getString("unperformPart"));
				}
				if(json.has("disruptTypeName")){
					legalLost.setDisruptTypeName(json.getString("disruptTypeName"));
				}
				if(json.has("publishDate")){
					legalLost.setPublishDate(json.getString("publishDate"));
				}
				
				legalLostDao.insertLegalLost(legalLost);
			}
			return str;
		}
		else{
			return JSONObject.fromObject(lgLost).toString();
		}
		
	}

	/**
	 * 分页查询本地数据库失信人列表
	 */
	public String ShixinDataListLocal(String iname,String currentPage) {
		Integer startIndex = 10*(Integer.valueOf(currentPage)-1);
		Integer perSize = 10;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startIndex", startIndex);
		map.put("perSize", perSize);
		map.put("iname", iname);
		List<LegalLost> list = legalLostDao.queryLegalLostList(map);
		Integer totalSize = legalLostDao.queryLegalLostListSize(iname);
		Integer totalPage = 0;
		if(totalSize%10 != 0){
			totalPage = totalSize/10 + 1;
		}
		else{
			totalPage = totalSize/10;
		}
		JSONArray dataList = JSONArray.fromObject(list);
		JSONObject obj = new JSONObject();
		obj.put("dataList", dataList);
		obj.put("currentPage", currentPage);
		obj.put("totalSize", totalSize);
		obj.put("totalPage", totalPage);
		return obj.toString();
	}

}
