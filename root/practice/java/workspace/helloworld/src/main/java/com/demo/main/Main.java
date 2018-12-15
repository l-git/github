package com.demo.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;



public class Main {

	private static final Logger logger=Logger.getLogger(Main.class);
	
	public static void main(String args[]){
		
	
		String s="`";
		
		System.out.println(ALLATORI_DEMO(s));
		
		System.out.println(ALLATORI_DEMO1(s));
		
	}
	
	
	public static String ALLATORI_DEMO(final String a) {
        final int n = 5 << 4;
        final int n2 = (0x2 ^ 0x5) << 4 ^ 0x3;
        final int length = a.length();
        final char[] array = new char[length];
        int n3;
        int i = n3 = length - 1;
        final char[] array2 = array;
        final char c = (char)n2;
        final int n4 = n;
        while (i >= 0) {
            final char[] array3 = array2;
            final int n5 = n3;
            final char char1 = a.charAt(n5);
            --n3;
            array3[n5] = (char)(char1 ^ n4);
            if (n3 < 0) {
                break;
            }
            final char[] array4 = array2;
            final int n6 = n3;
            final char c2 = (char)(a.charAt(n6) ^ c);
            --n3;
            array4[n6] = c2;
            i = n3;
        }
        return new String(array2);
    }
	
	public static String ALLATORI_DEMO1(final String a) {
        final int n = 5 << 4;
        final int n2 = 2;
        final int n3 = n ^ (n2 << n2 ^ 0x1);
        final int n4 = (0x3 ^ 0x5) << 4;
        final int n5 = 2;
        final int n6 = n4 ^ (n5 << n5 ^ 0x3);
        final int length = a.length();
        final char[] array = new char[length];
        int n7;
        int i = n7 = length - 1;
        final char[] array2 = array;
        final char c = (char)n6;
        final int n8 = n3;
        while (i >= 0) {
            final char[] array3 = array2;
            final int n9 = n7;
            final char char1 = a.charAt(n9);
            --n7;
            array3[n9] = (char)(char1 ^ n8);
            if (n7 < 0) {
                break;
            }
            final char[] array4 = array2;
            final int n10 = n7;
            final char c2 = (char)(a.charAt(n10) ^ c);
            --n7;
            array4[n10] = c2;
            i = n7;
        }
        return new String(array2);
    }
	
}
