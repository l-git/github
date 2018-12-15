package com.company.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.rest.Get;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.service.UserService;

public class UserController {

	private static final Logger logger=Logger.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	
	@Get
	public Object index(Invocation inv){
		
		
		return "user";
	}
	

	public Object selectUserList(Invocation inv){
		
		logger.debug("selectUserList");
		
		Map<String,Object> param=new HashMap<String,Object>();
		List<Map<String,Object>> userList=userService.selectUserList(param);
		
		
		return "@"+userList;
	}
	
	
	
	public Object insertUser(Invocation inv){
		
		userService.insertUserList(null);
		
		return "@1";
	}
	
	
	
	
	
}
