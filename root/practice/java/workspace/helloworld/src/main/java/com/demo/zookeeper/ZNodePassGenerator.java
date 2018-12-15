package com.demo.zookeeper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class ZNodePassGenerator {

	public static void main(String args[]){
		
		
		String s1="jIGoWJ05lZaUNNvfl0ZJf0p44cY=";
		
		//String s="BartServer:123456";
		
		String p="";
		for(int i=0;i<1000000;i++){
			p=""+i;
		
		int n=6;
		String z0="";
		int d=n-p.length();
		if(d!=0){
			while(d-->0){
				z0+="0";
				
			}
		}
		
		
		
		
		p=z0+p;
		String prefix="";
		p=prefix+p;
		
		System.out.println(p);
		
		try {
			String r=generateDigest(p);
			if(r.equals(s1)){
				System.out.println(p);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	static public String generateDigest(String idPassword)
            throws NoSuchAlgorithmException {
        String parts[] = idPassword.split(":", 2);
        byte digest[] = MessageDigest.getInstance("SHA1").digest(
                idPassword.getBytes());
        
        BASE64Encoder encoder = new BASE64Encoder();
        String bs64=encoder.encode(digest);
        //return parts[0] + ":" + bs64;
        return bs64;
    }
	
	
}
