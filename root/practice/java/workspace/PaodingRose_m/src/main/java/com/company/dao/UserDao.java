package com.company.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {

	
	List<Map<String,Object>> selectUserList(Map<String,Object> param);
	
	
	
	int insertUser(Map<String,Object> param);
	
	
}
