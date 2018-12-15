package com.demo.classloader;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;

import sun.io.ByteToCharBig5_HKSCS;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(HashMap.class.getClassLoader());

		System.out.println("class loader for DNSNameService: "
				+ ByteToCharBig5_HKSCS.class.getClassLoader());

		System.out.println(Main.class.getClassLoader());

		try {

			InputStream is = new FileInputStream("a.txt");

			DataInputStream d = new DataInputStream(is);

			String s = d.readLine();
			byte b[]=s.getBytes("utf8");
			
			byte bb[]={0x68,0x69,0x2c,(byte) 0xe4,(byte) 0xb8,(byte) 0xad};
			System.out.println(new String(bb));
			
			for(int i=0;i<b.length;i++){
				System.out.printf("%02x ", b[i]);
			}
			System.out.println();
			System.out.println(new String(b,"utf8"));
			System.out.println(s.length());

			/*Reader r = new FileReader("a.txt");
			int c;
			while ((c = r.read()) != -1) {
				System.out.print((char) c);
			}
*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
