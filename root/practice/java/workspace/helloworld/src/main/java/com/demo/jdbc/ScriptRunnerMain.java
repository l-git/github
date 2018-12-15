package com.demo.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ScriptRunnerMain {

	public static void main(String args[]){
		
		
		
		Connection mConnection = null;
		String SERVER="localhost";
		String DATABASE="orcl10";
		String USER="root";
		String PASSWORD="root";
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    mConnection = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE + "?" + "user=" + USER + "&password=" + PASSWORD);
		} catch (ClassNotFoundException e) {
		    System.err.println("Unable to get mysql driver: " + e);
		} catch (SQLException e) {
		    System.err.println("Unable to connect to server: " + e);
		}
		ScriptRunner runner = new ScriptRunner(mConnection, false, false);
		String file = "script.sql";
		try {
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
		}
		
		
		
		
		
		
		
		
	}
	
}
