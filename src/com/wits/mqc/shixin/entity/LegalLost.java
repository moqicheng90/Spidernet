package com.wits.mqc.shixin.entity;

import java.io.Serializable;

public class LegalLost implements Serializable{
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 4388588646903055815L;

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 关联失信人查询网查询记录的id
	 */
	private Integer did;
	
	/**
	 * 法务核查ID,关联cust_lg表的lg_chk_id
	 */
	private String lgChkId;
	
	/**
	 * 被执行人名称
	 */
	private String iname;
	
	/**
	 * 身份证号码/组织机构代码
	 */
	private String cardNum;
	
	/**
	 * 年龄
	 */
	private String age;
	
	/**
	 * 性别
	 */
	private String sexy;
	
	/**
	 * 个人/企业判断标志
	 */
	private String partyTypeName;
	
	/**
	 * 法定代表人/负责人
	 */
	private String businessEntity;
	
	/**
	 * 审批法院
	 */
	private String courtName;
	
	/**
	 * 地区
	 */
	private String areaName;
	
	/**
	 * 执行依据文号
	 */
	private String 	gistId;
	
	/**
	 * 立案时间
	 */
	private String regDate;
	
	/**
	 * 案号
	 */
	private String caseCode;
	
	/**
	 * 做出执行依据单位
	 */
	private String gistUnit;
	
	/**
	 * 生效法律文书确定的义务
	 */
	private String duty;
	
	/**
	 * 被执行人的履行情况
	 */
	private String performance;
	
	/**
	 * 已履行部分
	 */
	private String performedPart;
	
	/**
	 * 未履行部分
	 */
	private String unperformPart;
	
	/**
	 * 失信被执行人行为具体情况
	 */
	private String disruptTypeName;
	
	/**
	 * 发布时间
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

	