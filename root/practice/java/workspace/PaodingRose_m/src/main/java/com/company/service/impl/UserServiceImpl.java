package com.company.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.UserDao;
import com.company.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	private UserDao userDao;
	
	
	public List<Map<String, Object>> selectUserList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
		List<Map<String, Object>> userList=userDao.selectUserList(param);
		
		return userList;
	}


	@Override
	public int insertUserList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<3;i++){
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("username", "user"+i);
			
			m.put("password", "p"+i);
			m.put("createDate", new Date());
			userDao.insertUser(m);
		
		}
		
		
		
		
		
		return 0;
	}

}
