package com.demo.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;


public class ChilkatExample {

	public static void main(String args[]){
		
		
		Graphics g;
		
		
		Color c;
		
		Font f;
		
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	      
		// Get all font family name in a String[]
		String[] fontNames = env.getAvailableFontFamilyNames();
		for (String fontName : fontNames) {
		   System.out.println(fontName);
		}
		      
		// Construct all Font instance (with font size of 1)
		Font[] fonts = env.getAllFonts();
		for (Font font : fonts) {
		   System.out.println(font);
		}
		
		
		
		
	}
	
	
	
}
