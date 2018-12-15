package com.demo.main.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class A {

	
	public static void main(String args[]){
		
		AtomicInteger a=new AtomicInteger();
		
		AtomicInteger b=new AtomicInteger();
		
		String url="http://localhost:8080";
		
		for(int i=0;i<10000000;i++){
			
			
			new Thread(new NHttpRequest(url,a,b)).start();
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
}



class NHttpRequest implements Runnable{

	
	private String url;
	
	private AtomicInteger a;
	
	private AtomicInteger b;
	
	public void run() {
		// TODO Auto-generated method stub
		
		/*URL url=new URL(url);*/
		
		try {
			URL url1=new URL(url);
			
			HttpURLConnection httpUrlConnection=(HttpURLConnection) url1.openConnection();
			
			InputStream inputStream=httpUrlConnection.getInputStream();
			
			
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			
			String line;
			/*while((line=br.readLine())!=null){
				System.out.println(line);
			}*/
			
			int code=httpUrlConnection.getResponseCode();
			
			System.out.println(Thread.currentThread().getName()+":"+code);
			
			int n1 = 0,n2=0;
			if(code==200){
				n1=a.getAndIncrement();
			}else{
				n2=b.getAndIncrement();
			}
			
			if((n1+n2)==100){
				System.out.println(n1+n2);
			}
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public NHttpRequest(String url,AtomicInteger a,AtomicInteger b){
		this.url=url;
		this.a=a;
		this.b=b;
	}
	
	
}
