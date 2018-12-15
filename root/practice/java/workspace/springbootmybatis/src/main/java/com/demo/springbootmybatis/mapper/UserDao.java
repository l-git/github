package com.demo.springbootmybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {

	List<Map<String,Object>> select();
	
	
	
}
