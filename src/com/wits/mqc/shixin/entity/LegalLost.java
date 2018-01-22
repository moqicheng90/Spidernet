package com.wits.mqc.shixin.entity;

import java.io.Serializable;

public class LegalLost implements Serializable{
	
	/**
	 * ���к�
	 */
	private static final long serialVersionUID = 4388588646903055815L;

	/**
	 * ����
	 */
	private Integer id;
	
	/**
	 * ����ʧ���˲�ѯ����ѯ��¼��id
	 */
	private Integer did;
	
	/**
	 * ����˲�ID,����cust_lg���lg_chk_id
	 */
	private String lgChkId;
	
	/**
	 * ��ִ��������
	 */
	private String iname;
	
	/**
	 * ���֤����/��֯��������
	 */
	private String cardNum;
	
	/**
	 * ����
	 */
	private String age;
	
	/**
	 * �Ա�
	 */
	private String sexy;
	
	/**
	 * ����/��ҵ�жϱ�־
	 */
	private String partyTypeName;
	
	/**
	 * ����������/������
	 */
	private String businessEntity;
	
	/**
	 * ������Ժ
	 */
	private String courtName;
	
	/**
	 * ����
	 */
	private String areaName;
	
	/**
	 * ִ�������ĺ�
	 */
	private String 	gistId;
	
	/**
	 * ����ʱ��
	 */
	private String regDate;
	
	/**
	 * ����
	 */
	private String caseCode;
	
	/**
	 * ����ִ�����ݵ�λ
	 */
	private String gistUnit;
	
	/**
	 * ��Ч��������ȷ��������
	 */
	private String duty;
	
	/**
	 * ��ִ���˵��������
	 */
	private String performance;
	
	/**
	 * �����в���
	 */
	private String performedPart;
	
	/**
	 * δ���в���
	 */
	private String unperformPart;
	
	/**
	 * ʧ�ű�ִ������Ϊ�������
	 */
	private String disruptTypeName;
	
	/**
	 * ����ʱ��
	 */
	private String publishDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getLgChkId() {
		return lgChkId;
	}

	public void setLgChkId(String lgChkId) {
		this.lgChkId = lgChkId;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSexy() {
		return sexy;
	}

	public void setSexy(String sexy) {
		this.sexy = sexy;
	}

	public String getPartyTypeName() {
		return partyTypeName;
	}

	public void setPartyTypeName(String partyTypeName) {
		this.partyTypeName = partyTypeName;
	}

	public String getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(String businessEntity) {
		this.businessEntity = businessEntity;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getGistId() {
		return gistId;
	}

	public void setGistId(String gistId) {
		this.gistId = gistId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getCaseCode() {
		return caseCode;
	}

	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public String getGistUnit() {
		return gistUnit;
	}

	public void setGistUnit(String gistUnit) {
		this.gistUnit = gistUnit;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getPerformedPart() {
		return performedPart;
	}

	public void setPerformedPart(String performedPart) {
		this.performedPart = performedPart;
	}

	public String getUnperformPart() {
		return unperformPart;
	}

	public void setUnperformPart(String unperformPart) {
		this.unperformPart = unperformPart;
	}

	public String getDisruptTypeName() {
		return disruptTypeName;
	}

	public void setDisruptTypeName(String disruptTypeName) {
		this.disruptTypeName = disruptTypeName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LegalLost [age=" + age + ", areaName=" + areaName
				+ ", businessEntity=" + businessEntity + ", cardNum=" + cardNum
				+ ", caseCode=" + caseCode + ", courtName=" + courtName
				+ ", did=" + did + ", disruptTypeName=" + disruptTypeName
				+ ", duty=" + duty + ", gistId=" + gistId + ", gistUnit="
				+ gistUnit + ", id=" + id + ", iname=" + iname + ", lgChkId="
				+ lgChkId + ", partyTypeName=" + partyTypeName
				+ ", performance=" + performance + ", performedPart="
				+ performedPart + ", publishDate=" + publishDate + ", regDate="
				+ regDate + ", sexy=" + sexy + ", unperformPart="
				+ unperformPart + "]";
	}
	
}

	