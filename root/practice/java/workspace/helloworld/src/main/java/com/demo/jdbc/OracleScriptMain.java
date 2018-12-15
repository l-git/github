package com.demo.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleScriptMain {

	
	public static void main(String args[]){
		
		ResultSet rs = null;  
		  Statement stmt = null;  
		  Connection connection = null;  
		   
		  long start=System.currentTimeMillis();
		   
		   try {
			   
			   
			   //Class.forName("oracle.jdbc.driver.OracleDriver");  
			   //DriverManager.setLoginTimeout(10);
			   //mConnection = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE + "?" + "user=" + USER + "&password=" + PASSWORD);
			  //jdbc:mysql://<host>:<port>/<database_name>?useUnicode=true&characterEncoding=utf8
			   connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "admin", "admin");
			   
			   
			   System.out.println(connection);
			   //connection = DriverManager.getConnection("jdbc:mysql://localhost:1521/orcl?useUnicode=true&characterEncoding=utf8&connectTimeout=1&socketTimeout=1", "admin", "admin");
			   
			   
			   
			   
			   connection.setAutoCommit(false);
	/*		} catch (ClassNotFoundException e) {
			    System.err.println("Unable to get mysql driver: " + e);*/
			} catch (SQLException e) {
			    System.err.println("Unable to connect to server: " + e);
			}finally{
				long end=System.currentTimeMillis();
				   System.out.println(end-start);
			}
			ScriptRunner runner = new ScriptRunner(connection, false, false);
			String file = "copy.sql";
			/*try {
				runner.runScript(new BufferedReader(new FileReader(file)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		   
		   
		
		  
		
		
		
	}
	
	
}
