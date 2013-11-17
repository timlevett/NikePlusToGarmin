package com.timlevett.nptg.controller;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.timlevett.nptg.util.NPTGConstants.*;


@Controller
public class TokenCreationController {
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET) 
	public String returnLoginPage () {
		return "login";
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST) 
	public String buildLogin (@RequestParam(required=false) String name, @RequestParam String token, ModelMap model, HttpServletRequest request) {
		if(StringUtils.isBlank(token)) {
			model.addAttribute("error","token.required");
			return "login";
		}
		request.getSession().setAttribute(TOKEN,token);
		request.getSession().setAttribute(USER,name);
		return "home";
	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET) 
	public String logout( ModelMap model, HttpServletRequest request) {
		
		request.getSession().removeAttribute(TOKEN);
		request.getSession().removeAttribute(USER);
		
		return "login";
	}

}
