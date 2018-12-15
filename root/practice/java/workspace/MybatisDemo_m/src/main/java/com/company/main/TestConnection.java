package com.company.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.company.dao.ConnectionDao;
import org.apache.log4j.Logger;

public class TestConnection {

	private static final Logger logger=Logger.getLogger(TestConnection.class);

	public static void main(String args[]){
		
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			
			System.out.println(System.getProperty("java.class.path"));
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			ConnectionDao connectionDao=sqlSession.getMapper(com.company.dao.ConnectionDao.class);
			List<Map<String,Object>> conn=connectionDao.conn();
			
			System.out.println(conn);



			List<User> userList=connectionDao.selectUsers1();
			logger.debug(userList);



			Map<String,Object> param=new HashMap<String, Object>();
			param.put("username","admin");
			param.put("password","admin");
			List<Map<String,Object>> mapList=connectionDao.selectUsers(param);
			logger.debug(mapList);




			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		
		
	}
	
}
