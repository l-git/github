package com.demo.main.swing.tree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;

public class Main {

	public static void main(String args[]){
		
		
		JFrame frame=new JFrame("tree");
		
		MyTree root=new MyTree();
		root.setId("0");
		root.setName("name");
		
		
		MyTree t1=new MyTree();
		t1.setName("t1");
		t1.setId("1");
		
		MyTree t2=new MyTree();
		t2.setName("t2");
		t2.setId("2");
		
		List<MyTree> child=new ArrayList<MyTree>();
		child.add(t1);
		child.add(t2);
		root.setChild(child);
		
		
		
		
		MyTree myTree=new MyTree(root);
		
		JJTree tree=new JJTree(myTree);
		
		tree.addTreeSelectionListener(new TreeSelectionListener(){

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
				
				System.out.println(e.getPath());
				
				
				MyTree m=(MyTree) e.getPath().getLastPathComponent();
				/*System.out.println(m.getId());
				System.out.println(m.getName());*/
			}
			
		});
		
		
		JScrollPane j=new JScrollPane(tree);
		frame.add(j);
		
		frame.setSize(800,600);
		
		frame.setVisible(true);
		
		
		
		
		
		
		
	}
	
	
	
	
}

class ChainedSelectionEvent extends TreeSelectionEvent {
	  ChainedSelectionEvent(TreeSelectionEvent e) {
	    super(e.getSource(), e.getPaths(), new boolean[]{true}, e.getOldLeadSelectionPath(), e.getNewLeadSelectionPath());
	  }
	}
class JJTree extends JTree{
	
	public JJTree(TreeModel t){
		super(t);
	}
	
	
	protected void fireValueChanged(TreeSelectionEvent e) {
		  if(true) { // figure out separately
		      super.fireValueChanged(new ChainedSelectionEvent(e));
		  } else {
		      super.fireValueChanged(e);
		  }
	
	
	
	
	}}
