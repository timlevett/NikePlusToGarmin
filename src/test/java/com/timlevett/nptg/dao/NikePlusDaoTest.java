package com.timlevett.nptg.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.timlevett.nptg.model.Activity;

public class NikePlusDaoTest {
	
	protected String token = "REMOVED";
	NikePlusDaoImpl dao = new NikePlusDaoImpl();
	
	@Test
	public void getActivityTest() {
		List<Activity> results = dao.getActivities(token);
		for(Activity activity : results) {
			System.out.println(activity.getActivityType());
			System.out.println(activity.getMetricSummary().getDistance());
		}
		int size = results.size();
	}
	
	@Test
	public void getActivityGPSDataTest() {
		List<Activity> results = dao.getActivities(token);
		for(Activity activity : results) {
			dao.getActivityGPSData(token, activity);
			break;
		}
		int size = results.size();
	}
}
