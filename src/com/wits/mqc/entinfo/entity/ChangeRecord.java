package com.wits.mqc.entinfo.entity;

import java.io.Serializable;

public class ChangeRecord implements Serializable{
	
	private Integer entID;
	
	/**
	 * 变更事项
	 */
	private String changeItem;
	
	/**
	 * 变更前内容
	 */
	private String changeBefore;
	
	/**
	 * 变更后内容
	 */
	private String changeAfter;
	
	/**
	 * 变更日期
	 */
	private String changeDate;

	public Integer getEntID() {
		return entID;
	}

	public void setEntID(Integer entID) {
		this.entID = entID;
	}

	public String getChangeItem() {
		return changeItem;
	}

	public void setChangeItem(String changeItem) {
		this.changeItem = changeItem;
	}

	public String getChangeBefore() {
		return changeBefore;
	}

	public void setChangeBefore(String changeBefore) {
		this.changeBefore = changeBefore;
	}

	public String getChangeAfter() {
		return changeAfter;
	}

	public void setChangeAfter(String changeAfter) {
		this.changeAfter = changeAfter;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	@Override
	public String toString() {
		return "ChangeRecord [entID=" + entID + ", changeItem=" + changeItem
				+ ", changeBefore=" + changeBefore + ", changeAfter="
				+ changeAfter + ", changeDate=" + changeDate + "]";
	}
	
}
