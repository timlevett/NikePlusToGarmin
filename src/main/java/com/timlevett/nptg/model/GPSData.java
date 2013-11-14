package com.timlevett.nptg.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GPSData {
	private String elevationLoss;	
	private String elevationGain;	
	private String elevationMin;	
	private String elevationMax;
	private String intervalMetric;	
	private String intervalUnit;	
	private List<Coordinate> waypoints;
	
	public String getElevationLoss() {
		return elevationLoss;
	}
	public void setElevationLoss(String elevationLoss) {
		this.elevationLoss = elevationLoss;
	}
	public String getElevationGain() {
		return elevationGain;
	}
	public void setElevationGain(String elevationGain) {
		this.elevationGain = elevationGain;
	}
	public String getElevationMin() {
		return elevationMin;
	}
	public void setElevationMin(String elevationMin) {
		this.elevationMin = elevationMin;
	}
	public String getElevationMax() {
		return elevationMax;
	}
	public void setElevationMax(String elevationMax) {
		this.elevationMax = elevationMax;
	}
	public String getIntervalMetric() {
		return intervalMetric;
	}
	public void setIntervalMetric(String intervalMetric) {
		this.intervalMetric = intervalMetric;
	}
	public String getIntervalUnit() {
		return intervalUnit;
	}
	public void setIntervalUnit(String intervalUnit) {
		this.intervalUnit = intervalUnit;
	}
	public List<Coordinate> getWaypoints() {
		return waypoints;
	}
	public void setWayPoints(List<Coordinate> wayPoints) {
		this.waypoints = wayPoints;
	}
}
