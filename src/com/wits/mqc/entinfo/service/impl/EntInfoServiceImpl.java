package com.wits.mqc.entinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wits.mqc.entinfo.dao.EntInfoDao;
import com.wits.mqc.entinfo.entity.ChangeRecord;
import com.wits.mqc.entinfo.entity.EntBasicInfo;
import com.wits.mqc.entinfo.entity.EntInfo;
import com.wits.mqc.entinfo.entity.ShareHolderInfo;
import com.wits.mqc.entinfo.service.EntInfoService;
import com.wits.spider.comb.service.CombAllInfo;

@Service("entInfoService")
public class EntInfoServiceImpl implements EntInfoService {
	
	@Autowired
	private EntInfoDao entInfoDao;
	
	/**
	 * ��ѯ��ҵ��������ҵ�񷽷�(����������ݿ����,��ӱ������ݿ��ȡ,�����ز�����,���������ȡ,�����뵽�������ݿ�)
	 */
	public EntInfo queryEntInfo(String entName){
		
		EntBasicInfo info = entInfoDao.queryEntBasicInfo(entName);
		List<ChangeRecord> crs = null;
		List<ShareHolderInfo> shis = null;
		
		if(info == null){
			info = new EntBasicInfo();
			// ������
			CombAllInfo query = new CombAllInfo();
			// ������ҵ������ȡ�Ľ��
			String result = query.queryEntInfo(entName);
			// �������װ��json��ʽ
			JSONObject json = JSONObject.fromObject(result);
			System.out.println(json);
			// �ӽ����ȡ����ҵ������Ϣjson
			JSONObject infoJson = json.getJSONObject("entInfo");
			// ��ֵ
			info.setEntName(infoJson.getString("entName"));
			info.setEntPhone(infoJson.getString("entPhone"));
			info.setEntEmailAdress(infoJson.getString("entEmailAdress"));
			info.setEntAddress(infoJson.getString("entAddress"));
			info.setEntLegalPerson(infoJson.getString("entLegalPerson"));
			info.setEntRegistCapital(infoJson.getString("entRegistCapital"));
			info.setBusinessRegistNo(infoJson.getString("businessRegistNo"));
			info.setOrganizationCode(infoJson.getString("organizationCode"));
			info.setCreditCode(infoJson.getString("creditCode"));
			info.setEntType(infoJson.getString("entType"));
			info.setTaxpayerIdentificationNo(infoJson.getString("taxpayerIdentificationNo"));
			info.setIndustry(infoJson.getString("industry"));
			info.setBusinessTermFrom(infoJson.getString("businessTermFrom"));
			info.setBusinessTermEnd(infoJson.getString("businessTermEnd"));
			info.setApprovalDate(infoJson.getString("approvalDate"));
			info.setRegistAuthority(infoJson.getString("registAuthority"));
			info.setRegistAddress(infoJson.getString("registAddress"));
			info.setEntEngilshName(infoJson.getString("entEngilshName"));
			info.setBusinessScope(infoJson.getString("businessScope"));
			info.setEntStatus(infoJson.getString("entStatus"));
			info.setEntRegistDate(infoJson.getString("entRegistDate"));
			// 1  ���뱾�����ݿ��ent_basic_info
			entInfoDao.insertEntBasicInfo(info);
			
			//�����¼�б�
			crs = new ArrayList<ChangeRecord>();
			ChangeRecord cr = null;
			if(json.has("changes")){
				JSONArray changes = json.getJSONArray("changes");
				for (Object c : changes) {
					JSONObject obj = JSONObject.fromObject(c);
					cr = new ChangeRecord();
					cr.setEntID(info.getId());
					cr.setChangeItem(obj.getString("changeItem"));
					cr.setChangeBefore(obj.getString("changeBefore"));
					cr.setChangeAfter(obj.getString("changeAfter"));
					cr.setChangeDate(obj.getString("changeDate"));
					// 2  ���뱾�����ݿ��ent_change_records
					entInfoDao.insertChangeRecord(cr);
					crs.add(cr);
				}
			}
				
			shis = new ArrayList<ShareHolderInfo>();
			ShareHolderInfo shi = null;
			JSONArray shareholderInfo = json.getJSONObject("annualReports").getJSONArray("shareholderInfo");
			for (Object object : shareholderInfo) {
				JSONObject obj = JSONObject.fromObject(object);
				shi = new ShareHolderInfo();
				shi.setEntID(info.getId());
				shi.setShareholder(obj.getString("shareholder"));
				shi.setLiSubConAm(obj.getString("liSubConAm"));
				shi.setSubConDate(obj.getString("subConDate"));
				shi.setSubConFormName(obj.getString("subConFormName"));
				shi.setLiAcConAm(obj.getString("liAcConAm"));
				shi.setAcConDate(obj.getString("acConDate"));
				shi.setAcConFormName(obj.getString("acConFormName"));
				// 3  ���뱾�����ݿ��ent_shareholder_info
				entInfoDao.insertShareHolderInfo(shi);
				shis.add(shi);
			}		
		}
		else{
			if(info.getId() != null){
				crs = entInfoDao.queryChangeRecordsByEntID(info.getId());
				shis = entInfoDao.queryShareHolderInfosByEntID(info.getId());
			}
		}
		
		return new EntInfo(info,crs,shis);
		
	}

}
