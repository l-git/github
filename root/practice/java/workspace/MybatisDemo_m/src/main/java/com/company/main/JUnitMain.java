package com.company.main;

import java.io.IOException;
import java.io.InputStream;
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

public class JUnitMain {

	private static  Logger logger=Logger.getLogger(JUnitMain.class);
	
	@Test
	public void r(){
		
		logger.debug("junit..................");
		
	}
	
	
	/**
	 * 
	 * test procdure
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/**
	 * 
	 * 
	 * 
	delimiter ;;

create procedure select_user_by_id(
inout id int,
out username varchar(50),
out password varchar(50),
out create_date datetime

)

begin 

select
id,username,`password`,create_date
into 
id,username,password,create_date
 from t_system_users
where id=id;

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
			
			UserDao connectionDao=sqlSession.getMapper(com.company.dao.UserDao.class);
			
			List<User> userList=connectionDao.selectUsers();
			
			
			logger.debug(userList);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
