package com.demo.helloweb.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

public class VelocityDemo {

	
	@Test
	public void t1(){
		
		try{
			/*  first, get and initialize an engine  */
	        VelocityEngine ve = new VelocityEngine();
	        ve.init();
	        //System.out.println(System.getProperty("user.dir"));
	        /*  next, get the Template  */
	        Template t = ve.getTemplate( "loop.vm" );
	        /*  create a context and add data */
	        VelocityContext context = new VelocityContext();
	        context.put("name", "World");
	        
	        context.put("label", "World");
	        context.put("field", "World");
	        
	        
	        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	        
	        
	        String a="标题,摘要,链接,图片地址,公众号appid";
	        String aArr[]=a.split(",");
	        
	        String b="title,summary,link,picUrl,appId";
	        String bArr[]=b.split(",");
	        
	        
	        for(int i=0;i<aArr.length;i++){
	        	Map<String,Object> map=new HashMap<String,Object>();
	        	map.put("k1", "请输入");
	        	map.put("k", aArr[i]);
	        	map.put("v", bArr[i]);
	        	list.add(map);
	        }
	        
	        //allProducts
	        context.put("list", list);
	        
	        
	        
	        
	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        System.out.println( writer.toString() );     
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	
	
}
