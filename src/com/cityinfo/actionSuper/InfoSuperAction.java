package com.cityinfo.actionSuper;

import com.cityinfo.model.InfoSingle;
import com.cityinfo.model.SearchInfo;

@SuppressWarnings("serial")
public class InfoSuperAction extends MySuperAction {
	protected InfoSingle infoSingle;
	protected SearchInfo searchInfo;

	public InfoSingle getInfoSingle() {
		return infoSingle;
	}
	
	public void setInfoSingle(InfoSingle infoSingle) {
		this.infoSingle = infoSingle;
	}
	
	public SearchInfo getSearchInfo() {
		return searchInfo;
	}
	
	public void setSearchInfo(SearchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}
}
