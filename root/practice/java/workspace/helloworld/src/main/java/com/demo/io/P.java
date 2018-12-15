package com.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P {

	public static void main(String args[]){
		
		try {
			String filePath = "p.sql";
			StringBuffer stringBuffer = new StringBuffer();
			BufferedReader br = null;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					filePath),"UTF-8"));

			String line;

			while ((line = br.readLine()) != null) {
				 //line=line.replaceAll("--.*", "");
				stringBuffer.append(line);
				stringBuffer.append("\r\n");
			}

			br.close();

			String s=stringBuffer.toString();
			
			String sArr[]=s.split("\r\n/\r\n");
			
			System.out.println(sArr.length);
			
			System.out.println(s);
			
			
			
			
			
			
			
			System.out.println("===========================================================================================");
			String fileStr = stringBuffer.toString().replaceAll(
					"(?s)/\\*.*?\\*/", "");

			System.out.println(fileStr);
			filePath = "copy.sql";
			BufferedWriter bw = null;

			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filePath),"UTF-8"));

			bw.write(fileStr);

			bw.flush();

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
