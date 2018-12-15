package ws.cxf;

import javax.jws.WebService;

import ws.cxf.domain.User;


@WebService
public interface HelloService {

	
	public String f(String s1,String s2);
	
	
	
	String f2(String p1,Long l1);
	
	
	
	User getUser(Long id);
	

	
	
	
	
}
