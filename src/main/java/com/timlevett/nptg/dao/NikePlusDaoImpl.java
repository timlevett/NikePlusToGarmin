package com.timlevett.nptg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.timlevett.nptg.api.NikePlusDao;
import com.timlevett.nptg.model.AccountLookupResult;
import com.timlevett.nptg.model.Activity;
import com.timlevett.nptg.model.GPSData;

@Service
public class NikePlusDaoImpl implements NikePlusDao {
	
	private RestTemplate rest = new RestTemplate();
	private final String API_URL="https://api.nike.com/me/sport/";
	
	/* (non-Javadoc)
	 * @see com.timlevett.nptg.dao.NikePlusDao#getToken(java.lang.String, java.lang.String)
	 */
	public String getToken (String username, String password) {
		
		return "";
	}
	
	/* (non-Javadoc)
	 * @see com.timlevett.nptg.dao.NikePlusDao#getActivities(java.lang.String)
	 */
	public List<Activity> getActivities(String token) {
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token",token);
		
		AccountLookupResult obj = rest.getForObject(API_URL+"/activities?access_token={access_token}", AccountLookupResult.class, params);
		List<Activity> result = (List<Activity>)obj.getData();
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.timlevett.nptg.dao.NikePlusDao#getActivity(java.lang.String, java.lang.String)
	 */
	public Activity getActivity(String token, String activityId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token",token);
		params.put("activityId",activityId);
		Activity result = rest.getForObject(API_URL+"/activities/{activityId}?access_token={access_token}", Activity.class, params);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.timlevett.nptg.dao.NikePlusDao#getActivityGPSData(java.lang.String, com.timlevett.nptg.model.Activity)
	 */
	public GPSData getActivityGPSData(String token, Activity activity) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token",token);
		params.put("activityId",activity.getActivityId());
		GPSData result = rest.getForObject(API_URL+"/activities/{activityId}/gps?access_token={access_token}", GPSData.class, params);
		return result;
	}

}
