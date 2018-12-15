package com.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String args[]) {

		try {
			String filePath = "2.包创建.sql";
			StringBuffer stringBuffer = new StringBuffer();
			BufferedReader br = null;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					filePath)));

			String line;

			while ((line = br.readLine()) != null) {
				 line=line.replaceAll("--.*", "");
				stringBuffer.append(line);
				stringBuffer.append("\r\n");
			}

			br.close();

			System.out.println(stringBuffer.toString());
			System.out
					.println("===========================================================================================");
			String fileStr = stringBuffer.toString().replaceAll(
					"(?s)/\\*.*?\\*/", "");

			System.out.println(fileStr);
			filePath = "copy.sql";
			BufferedWriter bw = null;

			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filePath)));

			bw.write(fileStr);

			bw.flush();

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
