package com.cityinfo.model;

public class AdminShowType {
	private int infoType;
	private String typeState;
	private String typePayfor;
	
	public void setInfoType(int infotype) {
		this.infoType = infotype;
	}
	
	public int getInfoType() {
		return infoType;
	}
	
	public void setTypeState(String typestate) {
		this.typeState = typestate;
	}
	
	public String getTypeState() {
		return typeState;
	}
	
	public void setTypePayfor(String typepayfor) {
		this.typePayfor = typepayfor;
	}
	
	public String getTypePayfor() {
		return typePayfor;
	}
}
