package com.timlevett.nptg.model;

import java.math.BigDecimal;

public class Coordinate {
	private BigDecimal latitude;
	private BigDecimal longitude;
	private BigDecimal elevation;
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getElevation() {
		return elevation;
	}
	public void setElevation(BigDecimal elevation) {
		this.elevation = elevation;
	}
	
	
}
