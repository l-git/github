package com.demo.main.swing.tree;

import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class MyTree implements TreeModel{
	
	MyTree root;
	
	
	public MyTree() {}
	
	public MyTree(MyTree root) {
		super();
		this.root=root;
	}


	private String id;
	
	private String name;
	
	
	private List<MyTree> child;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<MyTree> getChild() {
		return child;
	}


	public void setChild(List<MyTree> child) {
		this.child = child;
	}


	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return root;
	}


	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		MyTree m=(MyTree) parent;
		if(m.getChild()==null)
			return null;
		return m.getChild().get(index);
	}


	@Override
	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		MyTree m=(MyTree) parent;
		return m.getChild()==null?0:m.getChild().size();
	}


	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		MyTree m=(MyTree) node;
		if(m.getChild()==null){
			return true;
		}
		
		return false;
	}


	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		
		System.out.println("valueForPathChanged");
		
		
		
	}


	@Override
	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		System.out.println("getIndexOfChild");
		return 0;
	}


	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		System.out.println("addTreeModelListener");
		
		
		
		
		
		
	}


	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		System.out.println("removeTreeModelListener");
		
		
		
		
		
		
		
	}
	
	
	
	
	public String toString() {
		
		return this.name;
		
	}
	
	
	
	
}
