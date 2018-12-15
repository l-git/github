package com.demo.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Main {

	public static void main(String args[]){
		Person p=new Person();
		p.setFirstname("fi name");
		p.setLastname("last name");
		XStream xstream = new XStream(new StaxDriver()); 
		//xstream.alias("p", Person.class);
		
		
		List<String> l=new ArrayList<String>();
		l.add("p");
		
		List<Class> clazz=new ArrayList<Class>();
		clazz.add(Person.class);
		
		alia(xstream,clazz,l);
		
		/*for(int i=0;i<clazz.size();i++){
			xstream.alias(l.get(i), clazz.get(i));
		}*/
		
		String xml = xstream.toXML(p);
		
		
		
		
		System.out.println(xml);
		
		String sss="<?xml version=\"1.0\" ?><p><firstname>fiffffffffff name</firstname><lastname>last name</lastname></p>";
		
		Person newJoe = (Person)xstream.fromXML(sss);
		
		System.out.println(newJoe);
		
	}
	
	
	static void alia(XStream xstream,List<Class> clazz,List<String> aliaList){
		
		/*for(Class c:clazz){
			xstream.alias(, type)
		}*/
		
		for(int i=0;i<clazz.size();i++){
			xstream.alias(aliaList.get(i), clazz.get(i));
		}
		
		
		
		
	}
	
}
