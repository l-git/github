package com.demo.mybatisspring.controllers;





import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

import com.demo.mybatisspring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/selectAll",method = RequestMethod.GET)
	public String selectAll(ModelMap model) {
		
		
		Map<String, Object> param = new HashMap<String,Object>();
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		
		userService.selectAll(param, result);
		
		logger.debug(result);
		
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return "user";
	}
	
	
	@RequestMapping(value="/selectUserJson",method = RequestMethod.GET)
	
	public @ResponseBody Object selectUserJson(ModelMap model) {
		
		
		Map<String, Object> param = new HashMap<String,Object>();
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		
		userService.selectAll(param, result);
		
		logger.debug(result);
		
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return result;
	}
	
	
}
