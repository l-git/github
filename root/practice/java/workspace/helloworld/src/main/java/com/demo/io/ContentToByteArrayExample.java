package com.demo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
 
public class ContentToByteArrayExample
{
   public static void main(String[] args) throws UnsupportedEncodingException
   {
	  
	   
	   
	   InputStream in = null;
	try {
		in = new FileInputStream(new File("e:/txt/1.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,"unicode"));//,"gbk"
	    StringBuilder out = new StringBuilder();
	    String line;
	    try {
			while ((line = reader.readLine()) != null) {
			    out.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   System.out.println(out.toString());
	   
	   
	   /* int n=1024;
	   byte[] b=new byte[1024*1024*1024];
	   
	   //*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024*1024
	   b[0]=23;
	   System.out.println(b.length);
	   //System.out.println(n);
      File file = new File("E:\\download\\CentOS-7-x86_64-DVD-1611.iso.td");*/
       //System.out.println(file.length()/1024/1024/1024);
     // readContentIntoByteArray(file);
   }
 
   private static byte[] readContentIntoByteArray(File file)
   {
      FileInputStream fileInputStream = null;
      byte[] bFile = new byte[(int) file.length()];
      
      
      try
      {
         //convert file into array of bytes
         fileInputStream = new FileInputStream(file);
         fileInputStream.read(bFile);
         fileInputStream.close();
         for (int i = 0; i < bFile.length; i++)
         {
            System.out.print((char) bFile[i]);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return bFile;
   }
}