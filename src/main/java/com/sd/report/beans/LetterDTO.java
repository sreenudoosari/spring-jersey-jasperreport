package com.sd.report.beans;

import java.util.List;

public class LetterDTO {

	private String title;
	private String subTitle;
	private List<DataBean> listeData;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public List<DataBean> getListeData() {
		return listeData;
	}
	public void setListeData(List<DataBean> listeData) {
		this.listeData = listeData;
	}
	
}
