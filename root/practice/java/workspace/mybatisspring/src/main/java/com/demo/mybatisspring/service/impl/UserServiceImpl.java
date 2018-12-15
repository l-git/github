package com.demo.mybatisspring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mybatisspring.dao.UserDao;
import com.demo.mybatisspring.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	
	
	@Autowired
	private UserDao userDao;

	public void selectAll(Map<String, Object> param, Map<String, Object> result) {
		// TODO Auto-generated method stub
		
		
		List<Map<String, Object>> list=userDao.selectAll();
		
		result.put("list", list);
		
	}
	
	
	
	
	
	
	
	
	
	
}
