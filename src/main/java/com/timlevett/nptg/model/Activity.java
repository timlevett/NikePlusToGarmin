package com.timlevett.nptg.model;

import java.util.Date;
import java.util.LinkedList;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ext.CoreXMLDeserializers.DurationDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
	
	String activityId;
	String activityType;
	@JsonDeserialize(using = DateDeserializer.class)
	Date startTime;
	String activityTimeZone;
	String status;
	String deviceType;
	MetricSummary metricSummary;
	LinkedList <Tag> tags;
	LinkedList <Metric> metrics;
	
	public class MetricSummary {
		Integer calories;
		Integer fuel;
		Integer steps;
		Float distance;
		
		String duration;
		
		public Integer getCalories() {
			return calories;
		}
		public void setCalories(Integer calories) {
			this.calories = calories;
		}
		public Integer getFuel() {
			return fuel;
		}
		public void setFuel(Integer fuel) {
			this.fuel = fuel;
		}
		public Float getDistance() {
			return distance;
		}
		public void setDistance(Float distance) {
			this.distance = distance;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public Integer getSteps() {
			return steps;
		}
		public void setSteps(Integer steps) {
			this.steps = steps;
		}
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getActivityTimeZone() {
		return activityTimeZone;
	}

	public void setActivityTimeZone(String activityTimeZone) {
		this.activityTimeZone = activityTimeZone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public MetricSummary getMetricSummary() {
		return metricSummary;
	}

	public void setMetricSummary(MetricSummary metricSummary) {
		this.metricSummary = metricSummary;
	}

	public LinkedList<Tag> getTags() {
		return tags;
	}

	public void setTags(LinkedList<Tag> tags) {
		this.tags = tags;
	}

	public LinkedList<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(LinkedList<Metric> metrics) {
		this.metrics = metrics;
	}
	
	
}
