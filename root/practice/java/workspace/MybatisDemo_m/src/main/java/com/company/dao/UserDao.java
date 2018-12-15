package com.company.dao;

import java.util.List;
import java.util.Map;

import com.company.domain.User;

public interface UserDao {

	
	List<User> selectUsers();
	
	
	int insert(Map<String,Object> map);
	
	
	int update(Map<String,Object> map);
	
	
	
	void callSelectUserById(Map<String,Object> map);
	
	void callBean(User user);
	
	
}
