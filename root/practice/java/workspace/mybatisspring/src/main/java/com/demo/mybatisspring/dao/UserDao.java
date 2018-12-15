package com.demo.mybatisspring.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {

	
	List<Map<String,Object>> selectAll();
	
	
}
