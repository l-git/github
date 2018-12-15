package com.demo.main.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {

	
	public static void main(String args[]){
		
		try {
			
			
			Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",8888));
			URL url=new URL("http://www.csdn.net");
			
			
			
			HttpURLConnection c=(HttpURLConnection) url.openConnection(proxy);
			
			/*c.setDoOutput(true);
			c.setDoInput(true);*/
			
			PrintWriter pw=new PrintWriter(c.getOutputStream());
			
			pw.write("oo");
			
			pw.flush();
			
			
			InputStream inputStream=c.getInputStream();
			
			
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			
			
			
			
			
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
}
