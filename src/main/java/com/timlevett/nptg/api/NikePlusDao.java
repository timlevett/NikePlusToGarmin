package com.timlevett.nptg.api;

import java.util.List;

import com.timlevett.nptg.model.Activity;
import com.timlevett.nptg.model.GPSData;

public interface NikePlusDao {

	public abstract String getToken(String username, String password);

	public abstract List<Activity> getActivities(String token);

	public abstract Activity getActivity(String token, String activityId);

	public abstract GPSData getActivityGPSData(String token, Activity activity);

}