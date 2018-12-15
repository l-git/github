package com.company.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class UploadController {

	private static final Logger logger = Logger
			.getLogger(UploadController.class);

	private static final String directory = "uploads";

	@Get
	public Object index() {

		return "upload";
	}

	
	@Get("upload")
	public Object upload(Invocation inv){
		
		
		return "@upload";
	}
	
	
	@Post("upload")
	public Object upload(MultipartFile[] files) {
		try {
			logger.debug(files);

			for (MultipartFile file : files) {

				String name = file.getName();
				logger.debug(name);

				InputStream inputStream = file.getInputStream();

				File folder=new File("e:/uploads/");
				if(!folder.exists()){
					folder.mkdirs();
				}
				File png=new File(folder,System.currentTimeMillis()+".png");
				
				OutputStream outputStream=new FileOutputStream(png);
				
				byte buffer[]=new byte[1024];
				
				int n;
				while((n=inputStream.read(buffer))!=-1){
					
					outputStream.write(buffer,0,n);
					
				}
				
				outputStream.flush();
				outputStream.close();
				
				logger.info("save file ok:"+file);
				
				
				
				
				
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "@ok-" + Arrays.toString(files);
	}

}
