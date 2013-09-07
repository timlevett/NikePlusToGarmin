package com.timlevett.nptg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;

import org.springframework.web.client.RestTemplate;

import com.timlevett.nptg.model.AccountLookupResult;
import com.timlevett.nptg.model.Activity;

public class NikePlusDaoImpl {
	
	public String getToken (String username, String password) {
		
		return "";
	}
	
	public List<Activity> getActivities(String token) {
		RestTemplate rest = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token",token);
		
		AccountLookupResult obj = rest.getForObject("https://api.nike.com/me/sport/activities?access_token={access_token}", AccountLookupResult.class, params);
		List<Activity> result = (List<Activity>)obj.getData();
		
		return result;
	}

}
