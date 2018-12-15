package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {

		try {
			PrintWriter pw=resp.getWriter();
			
			
			int a=1;
			int b=0;
			
			int c=a/b;
			
			
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			pw.write("{\"a\":\"b\"}");
			
			pw.flush();
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		
		try {
			PrintWriter pw=resp.getWriter();
			
			
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			pw.write("{\"a\":\"b\"}");
			
			pw.flush();
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
