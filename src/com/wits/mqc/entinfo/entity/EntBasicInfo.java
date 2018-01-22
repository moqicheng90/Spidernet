package com.wits.mqc.entinfo.entity;

import java.io.Serializable;

public class EntBasicInfo implements Serializable{
	
	private Integer id;
	
	/**
	 * 企业名称
	 */
	private String entName;
	
	/**
	 * 工商注册号
	 */
	private String businessRegistNo;
	
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	
	/**
	 * 统一信用代码
	 */
	private String creditCode;
	
	/**
	 * 企业类型
	 */
	private String entType;
	
	/**
	 * 纳税人识别号
	 */
	private String taxpayerIdentificationNo;
	
	/**
	 * 所属行业
	 */
	private String industry;
	
	/**
	 * 经营期限自
	 */
	private String businessTermFrom;
	
	/**
	 * 经营期限至
	 */
	private String businessTermEnd;
	
	/**
	 * 核准日期
	 */
	private String approvalDate;
	
	/**
	 * 登记机关
	 */
	private String registAuthority;
	
	/**
	 * 企业注册地址
	 */
	private String registAddress;
	
	/**
	 * 企业英文名称
	 */
	private String entEngilshName;
	
	/**
	 * 经营范围
	 */
	private String businessScope;
	
	/**
	 * 企业法人
	 */
	private String entLegalPerson;
	
	/**
	 * 企业地址
	 */
	private String entAddress;
	
	/**
	 * 企业邮箱
	 */
	private String entEmailAdress;
	
	/**
	 * 联系电话
	 */
	private String entPhone;
	
	/**
	 * 注册资本
	 */
	private String entRegistCapital;
	
	/**
	 * 企业状态
	 */
	private String entStatus;
	
	/**
	 * 注册日期
	 */
	private String entRegistDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getBusinessRegistNo() {
		return businessRegistNo;
	}

	public void setBusinessRegistNo(String businessRegistNo) {
		this.businessRegistNo = businessRegistNo;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getTaxpayerIdentificationNo() {
		return taxpayerIdentificationNo;
	}

	public void setTaxpayerIdentificationNo(String taxpayerIdentificationNo) {
		this.taxpayerIdentificationNo = taxpayerIdentificationNo;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getBusinessTermFrom() {
		return businessTermFrom;
	}

	public void setBusinessTermFrom(String businessTermFrom) {
		this.businessTermFrom = businessTermFrom;
	}

	public String getBusinessTermEnd() {
		return businessTermEnd;
	}

	public void setBusinessTermEnd(String businessTermEnd) {
		this.businessTermEnd = businessTermEnd;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getRegistAuthority() {
		return registAuthority;
	}

	public void setRegistAuthority(String registAuthority) {
		this.registAuthority = registAuthority;
	}

	public String getRegistAddress() {
		return registAddress;
	}

	public void setRegistAddress(String registAddress) {
		this.registAddress = registAddress;
	}

	public String getEntEngilshName() {
		return entEngilshName;
	}

	public void setEntEngilshName(String entEngilshName) {
		this.entEngilshName = entEngilshName;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getEntLegalPerson() {
		return entLegalPerson;
	}

	public void setEntLegalPerson(String entLegalPerson) {
		this.entLegalPerson = entLegalPerson;
	}

	public String getEntAddress() {
		return entAddress;
	}

	public void setEntAddress(String entAddress) {
		this.entAddress = entAddress;
	}

	public String getEntEmailAdress() {
		return entEmailAdress;
	}

	public void setEntEmailAdress(String entEmailAdress) {
		this.entEmailAdress = entEmailAdress;
	}

	public String getEntPhone() {
		return entPhone;
	}

	public void setEntPhone(String entPhone) {
		this.entPhone = entPhone;
	}

	public String getEntRegistCapital() {
		return entRegistCapital;
	}

	public void setEntRegistCapital(String entRegistCapital) {
		this.entRegistCapital = entRegistCapital;
	}

	public String getEntStatus() {
		return entStatus;
	}

	public void setEntStatus(String entStatus) {
		this.entStatus = entStatus;
	}

	public String getEntRegistDate() {
		return entRegistDate;
	}

	public void setEntRegistDate(String entRegistDate) {
		this.entRegistDate = entRegistDate;
	}

	@Override
	public String toString() {
		return "EntBasicInfo [id=" + id + ", entName=" + entName
				+ ", businessRegistNo=" + businessRegistNo
				+ ", organizationCode=" + organizationCode + ", creditCode="
				+ creditCode + ", entType=" + entType
				+ ", taxpayerIdentificationNo=" + taxpayerIdentificationNo
				+ ", industry=" + industry + ", businessTermFrom="
				+ businessTermFrom + ", businessTermEnd=" + businessTermEnd
				+ ", approvalDate=" + approvalDate + ", registAuthority="
				+ registAuthority + ", registAddress=" + registAddress
				+ ", entEngilshName=" + entEngilshName + ", businessScope="
				+ businessScope + ", entLegalPerson=" + entLegalPerson
				+ ", entAddress=" + entAddress + ", entEmailAdress="
				+ entEmailAdress + ", entPhone=" + entPhone
				+ ", entRegistCapital=" + entRegistCapital + ", entStatus="
				+ entStatus + ", entRegistDate=" + entRegistDate + "]";
	}

}
