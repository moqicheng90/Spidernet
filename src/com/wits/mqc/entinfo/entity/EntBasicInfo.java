package com.wits.mqc.entinfo.entity;

import java.io.Serializable;

public class EntBasicInfo implements Serializable{
	
	private Integer id;
	
	/**
	 * ��ҵ����
	 */
	private String entName;
	
	/**
	 * ����ע���
	 */
	private String businessRegistNo;
	
	/**
	 * ��֯��������
	 */
	private String organizationCode;
	
	/**
	 * ͳһ���ô���
	 */
	private String creditCode;
	
	/**
	 * ��ҵ����
	 */
	private String entType;
	
	/**
	 * ��˰��ʶ���
	 */
	private String taxpayerIdentificationNo;
	
	/**
	 * ������ҵ
	 */
	private String industry;
	
	/**
	 * ��Ӫ������
	 */
	private String businessTermFrom;
	
	/**
	 * ��Ӫ������
	 */
	private String businessTermEnd;
	
	/**
	 * ��׼����
	 */
	private String approvalDate;
	
	/**
	 * �Ǽǻ���
	 */
	private String registAuthority;
	
	/**
	 * ��ҵע���ַ
	 */
	private String registAddress;
	
	/**
	 * ��ҵӢ������
	 */
	private String entEngilshName;
	
	/**
	 * ��Ӫ��Χ
	 */
	private String businessScope;
	
	/**
	 * ��ҵ����
	 */
	private String entLegalPerson;
	
	/**
	 * ��ҵ��ַ
	 */
	private String entAddress;
	
	/**
	 * ��ҵ����
	 */
	private String entEmailAdress;
	
	/**
	 * ��ϵ�绰
	 */
	private String entPhone;
	
	/**
	 * ע���ʱ�
	 */
	private String entRegistCapital;
	
	/**
	 * ��ҵ״̬
	 */
	private String entStatus;
	
	/**
	 * ע������
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
