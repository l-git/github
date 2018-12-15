package com.demo.swing;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

public class MyTreeTreeCellRenderer extends DefaultTreeCellRenderer{

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		// TODO Auto-generated method stub
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		
		
		
		
		MyTree m=(MyTree) value;
		super.setText(m.getName());
		
		//System.out.println(System.getProperty("user.dir"));
		java.net.URL imgURL = this.getClass().getResource("checked.gif");
		
		System.out.println(imgURL);
		imgURL = this.getClass().getResource("/");
		
		System.out.println(imgURL);
		
		System.out.println("===================================");
		
		
	    if (imgURL != null) {
	     super.setIcon(new ImageIcon(imgURL));
	    }
		
		return this;
	}

}
