package com.wits.mqc.entinfo.entity;

import java.io.Serializable;
import java.util.List;

public class EntInfo implements Serializable{

	private EntBasicInfo ebi;
	
	private List<ChangeRecord> crs;
	
	private List<ShareHolderInfo> shis;
	
	public EntInfo() {
		super();
	}

	public EntInfo(EntBasicInfo ebi, List<ChangeRecord> crs,
			List<ShareHolderInfo> shis) {
		super();
		this.ebi = ebi;
		this.crs = crs;
		this.shis = shis;
	}

	public EntBasicInfo getEbi() {
		return ebi;
	}

	public void setEbi(EntBasicInfo ebi) {
		this.ebi = ebi;
	}

	public List<ChangeRecord> getCrs() {
		return crs;
	}

	public void setCrs(List<ChangeRecord> crs) {
		this.crs = crs;
	}

	public List<ShareHolderInfo> getShis() {
		return shis;
	}

	public void setShis(List<ShareHolderInfo> shis) {
		this.shis = shis;
	}

	@Override
	public String toString() {
		return "EntInfo [ebi=" + ebi + ", crs=" + crs + ", shis=" + shis + "]";
	}
	
}
