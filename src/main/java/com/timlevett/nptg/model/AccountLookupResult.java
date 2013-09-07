package com.timlevett.nptg.model;

import java.util.LinkedHashMap;
import java.util.List;

public class AccountLookupResult {
	private List<Activity> data;
	private LinkedHashMap paging;
	public List<Activity> getData() {
		return data;
	}
	public void setData(List<Activity> data) {
		this.data = data;
	}
	public LinkedHashMap getPaging() {
		return paging;
	}
	public void setPaging(LinkedHashMap paging) {
		this.paging = paging;
	}
}