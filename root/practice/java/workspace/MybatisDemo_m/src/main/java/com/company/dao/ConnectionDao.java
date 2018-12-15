package com.company.dao;

import java.util.List;
import java.util.Map;

import com.company.domain.User;

public interface ConnectionDao {

	public List<Map<String,Object>> conn();
	
	
	public List<User> selectUsers1();

	public List<Map<String,Object>> selectUsers(Map<String,Object> param);


	
}
