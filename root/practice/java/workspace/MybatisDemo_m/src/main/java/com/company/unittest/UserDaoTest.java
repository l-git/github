package com.company.unittest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.company.dao.UserDao;
import com.company.domain.User;
import com.company.utils.SqlSessionUtil;

public class UserDaoTest {

	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void r() {

		try {
			SqlSession sqlSession = SqlSessionUtil.getSqlSession();

			List<User> userList = sqlSession.selectList("selectUsers");

			logger.debug(userList);

			logger.debug("=================================");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void r1() {

		try {

			SqlSession sqlSession = SqlSessionUtil.getSqlSession();

			UserDao userDao = sqlSession.getMapper(UserDao.class);
			List<User> userList = userDao.selectUsers();

			logger.debug(userList);

			userDao.selectUsers();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void insert() {

		try {

			SqlSession sqlSession = SqlSessionUtil.getSqlSession();

			UserDao userDao = sqlSession.getMapper(UserDao.class);
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			map.put("username", "name1121");
			map.put("password", "jijfi");
			
			int i=userDao.insert(map);
			
			
			
			
			logger.debug(map);

			
			/*sqlSession.commit();*/
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	@Test
	public void update(){
		
		try {

			SqlSession sqlSession = SqlSessionUtil.getSqlSession();

			UserDao userDao = sqlSession.getMapper(UserDao.class);
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			map.put("username", "1234");
			map.put("password", "5679");
			map.put("id", "28");
			
			int i=userDao.update(map);
			
			
			
			
			logger.debug(map);

			
			sqlSession.commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
