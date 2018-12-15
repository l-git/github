package com.company.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.company.dao.ConnectionDao;
import com.company.dao.UserDao;
import com.company.domain.User;

public class UserDaoMain {
	
	
	private static final Logger logger =Logger.getLogger(UserDaoMain.class);
	
	
public static void main(String args[]){
		
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			
			logger.debug(System.getProperty("java.class.path"));
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			ConnectionDao connectionDao=sqlSession.getMapper(com.company.dao.ConnectionDao.class);
			List<Map<String,Object>> conn=connectionDao.conn();
			
			logger.debug(conn);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}





/**
 * 
 * 
 * 




delimiter ;;

drop procedure if exists select_user_by_id;
create procedure select_user_by_id(
in id1 int,
out username1 varchar(100),
out password1 varchar(50),
out createDate1 datetime

)

begin 

select
username,password,create_date
into 
username1,password1,createDate1
 from t_system_users
where id=id1
limit 1
;

end
;;
delimiter ;





 * 
 * 
 * 
 * 
 */




@Test
public void testProcedure(){
	
	String resource = "mybatis-config.xml";
	InputStream inputStream;
	try {
		
		logger.debug(System.getProperty("java.class.path"));
		
		inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		UserDao userDao=sqlSession.getMapper(com.company.dao.UserDao.class);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", 1);
		userDao.callSelectUserById(map);
		
		logger.debug(map);
		
		User user=new User();
		user.setId(1L);
		userDao.callBean(user);
		
		
		logger.debug(user);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
















}
