package com.timlevett.nptg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.topografix.gpx._1._0.Gpx;

import com.timlevett.nptg.api.NikePlusDao;
import com.timlevett.nptg.model.Activity;
import com.timlevett.nptg.model.GPSData;
import com.timlevett.nptg.transformer.TransformNikePlusToGPX;
import com.timlevett.nptg.util.GpxToOutputStream;
import com.topografix.gpx._1._1.GpxType;

import static com.timlevett.nptg.util.NPTGConstants.*;

@Controller
public class ViewActivityController {
	
	@Autowired
	private NikePlusDao npd;
	
	@RequestMapping(value="/List")
	public String getListOfActivities(HttpServletRequest request, ModelMap modelMap) {
		String token = (String)request.getSession().getAttribute(TOKEN);
		
		if(null != token) {
			List<Activity> activities = npd.getActivities(token);
			modelMap.addAttribute("activities",activities);
			return VIEW_ACTIVITIES;
		} else {
			modelMap.addAttribute(ERROR, "error.notoken");
			return LOGIN;
		}
	}
	
	@RequestMapping(value="/export")
	public void exportActivity(@RequestParam String activityId, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException, Exception {
		String token = (String)request.getSession().getAttribute(TOKEN);
		
		Activity activity = npd.getActivity(token, activityId);
		GPSData activityGPSData = npd.getActivityGPSData(token, activity);
		TransformNikePlusToGPX transformer = new TransformNikePlusToGPX();
		com.topografix.gpx._1._0.Gpx gpx = transformer.toGPX(activity, activityGPSData);
		GpxToOutputStream outputStream = new GpxToOutputStream();
		response.setContentType("application/gpx+xml");
		response.setHeader("Content-Disposition","attachment; filename=\"" + activityId + ".gpx\"");//fileName);
		
		outputStream.getOutputstream(gpx, response.getOutputStream());
	}
}
