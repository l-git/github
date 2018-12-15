package com.demo.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class Main {

	public static void main(String args[]){
		
		
		
		try{
		/*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        //System.out.println(System.getProperty("user.dir"));
        /*  next, get the Template  */
        Template t = ve.getTemplate( "Main.vm" );
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "World");
        
        Person p=new Person();
        p.setId(1001L);
        p.setName("nameffff");
        
        context.put("p", p);
        
        
        context.put("a", "cccc");
        
        context.put("b", "cccc");
        
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


