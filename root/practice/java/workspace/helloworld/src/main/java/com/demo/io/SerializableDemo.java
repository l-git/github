package com.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializableDemo {

	
	public static void main(String args[]) throws Exception{
		
		
		OutputStream os=new FileOutputStream("a");
		
		
		ObjectOutputStream oos=new ObjectOutputStream(os);
		
		
		
		Student stu=new Student();
		
		stu.setId("id");
		stu.setName("name");
		
		
		
		oos.writeObject(stu);
		
		
		InputStream is=new FileInputStream("a");
		
		
		ObjectInputStream ois=new ObjectInputStream(is);
		
		
		Student s=	(Student) ois.readObject();
		
		System.out.println(s);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
