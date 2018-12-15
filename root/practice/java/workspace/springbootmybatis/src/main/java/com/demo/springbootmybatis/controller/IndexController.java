package com.demo.springbootmybatis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootmybatis.mapper.UserDao;


@RestController
public class IndexController {

	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	String index(){
		
		return "index";
	}
	
	@RequestMapping("/select")
	String select(){
		
		List<Map<String,Object>> list=userDao.select();
		
		
		System.out.println(list);
		
		
		return "select";
	}
	
	
}
