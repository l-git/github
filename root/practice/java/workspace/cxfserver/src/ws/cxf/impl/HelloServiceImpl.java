package ws.cxf.impl;

import javax.jws.WebService;

import ws.cxf.HelloService;
import ws.cxf.domain.User;


@WebService
public class HelloServiceImpl implements HelloService{

	
	
	
public String f(String s1,String s2){
		
		
		System.out.println("1234");
		
		
		return s1+":"+s2;
		
	}



public String f2(String p1, Long l1) {
	// TODO Auto-generated method stub
	
	
	
	System.out.println("f2  77");
	
	
	
	
	return p1+"-----------"+l1;
}



public User getUser(Long id) {
	// TODO Auto-generated method stub
	
	ws.cxf.a.User a=new ws.cxf.a.User();
	
	a.setA("aaa"+id);
	
	
	User u=new User();
	
	u.setId(id);

	u.setUsername("username:"+id);
	
	return u;
}





	
	
}
