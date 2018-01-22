package com.wits.mqc.entinfo.entity;

import java.io.Serializable;

public class ShareHolderInfo implements Serializable{
	
	private Integer entID;
	
	/**
	 * �ɶ�
	 */
	private String shareholder;
	
	/**
	 * �Ͻɳ��ʶ�
	 */
	private String liSubConAm;
	
	/**
	 * �Ͻɳ���ʱ��
	 */
	private String subConDate;
	
	/**
	 * �Ͻɳ��ʷ�ʽ
	 */
	private String subConFormName;
	
	/**
	 * ʵ�ɳ��ʶ�
	 */
	private String liAcConAm;
	
	/**
	 * ʵ�ɳ���ʱ��
	 */
	private String acConDate;
	
	/**
	 * ʵ�ɳ��ʷ�ʽ
	 */
	private String acConFormName;
	
	/**
	 * ֤������
	 */
	private String idcardType;
	
	/**
	 * ֤������
	 */
	private String idcardNo;

	public Integer getEntID() {
		return entID;
	}

	public void setEntID(Integer entID) {
		this.entID = entID;
	}

	public String getShareholder() {
		return shareholder;
	}

	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}

	public String getLiSubConAm() {
		return liSubConAm;
	}

	public void setLiSubConAm(String liSubConAm) {
		this.liSubConAm = liSubConAm;
	}

	public String getSubConDate() {
		return subConDate;
	}

	public void setSubConDate(String subConDate) {
		this.subConDate = subConDate;
	}

	public String getSubConFormName() {
		return subConFormName;
	}

	public void setSubConFormName(String subConFormName) {
		this.subConFormName = subConFormName;
	}

	public String getLiAcConAm() {
		return liAcConAm;
	}

	public void setLiAcConAm(String liAcConAm) {
		this.liAcConAm = liAcConAm;
	}

	public String getAcConDate() {
		return acConDate;
	}

	public void setAcConDate(String acConDate) {
		this.acConDate = acConDate;
	}

	public String getAcConFormName() {
		return acConFormName;
	}

	public void setAcConFormName(String acConFormName) {
		this.acConFormName = acConFormName;
	}

	public String getIdcardType() {
		return idcardType;
	}

	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	@Override
	public String toString() {
		return "ShareHolderInfo [entID=" + entID + ", shareholder="
				+ shareholder + ", liSubConAm=" + liSubConAm + ", subConDate="
				+ subConDate + ", subConFormName=" + subConFormName
				+ ", liAcConAm=" + liAcConAm + ", acConDate=" + acConDate
				+ ", acConFormName=" + acConFormName + ", idcardType="
				+ idcardType + ", idcardNo=" + idcardNo + "]";
	}
	
}
