package com.timlevett.nptg.model;

import java.util.List;

public class Metric {
	private Integer intervalMetric;
	private String intervalUnit;
	private String metricType;
	private List<Float> values;
	
	public Integer getIntervalMetric() {
		return intervalMetric;
	}
	public void setIntervalMetric(Integer intervalMetric) {
		this.intervalMetric = intervalMetric;
	}
	public String getIntervalUnit() {
		return intervalUnit;
	}
	public void setIntervalUnit(String intervalUnit) {
		this.intervalUnit = intervalUnit;
	}
	public String getMetricType() {
		return metricType;
	}
	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}
	public List<Float> getValues() {
		return values;
	}
	public void setValues(List<Float> values) {
		this.values = values;
	}
}
	