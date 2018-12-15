package com.demo.swing;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {

		
		// TODO Auto-generated method stub

		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				JFrame j=new JFrame();
				
				//j.setSize(200, 300);
				
				Toolkit Toolkit=j.getToolkit();
				;
				j.setSize(Toolkit.getScreenSize());
				j.setLayout(new FlowLayout());
				
				JDialog d=new JDialog(j,"jfiejfie");
				d.setVisible(true);
				
				j.getContentPane().add(new JLabel("fefefefef"));
				
				j.setVisible(true);
				
				
				
				
				
			}
			
			
			
			
		});
		
		
		
	}

}
