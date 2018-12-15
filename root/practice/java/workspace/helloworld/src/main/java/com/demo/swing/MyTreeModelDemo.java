package com.demo.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class MyTreeModelDemo {
	
	public static void main(String args[]){
		
		
		JFrame jFrame=new JFrame();
		
		
		JTree jTree=new JTree();
		
		
		
		MyTree root=new MyTree();
		root.setName("root");
		root.setIsLeaf(false);
		
		
		
		MyTree t11=new MyTree();
		t11.setName("11");
		t11.setParent(root);
		t11.setIsLeaf(true);
		
		root.getChildren().add(t11);
		
		MyTree t12=new MyTree();
		t12.setName("12");
		t12.setParent(root);
		t12.setIsLeaf(false);
		
		root.getChildren().add(t12);
		
		MyTree t123=new MyTree();
		t123.setName("123");
		t123.setParent(t12);
		t123.setIsLeaf(true);
		
		t12.getChildren().add(t123);
		
		MyTree t1234=new MyTree();
		t1234.setName("1234");
		t1234.setParent(t12);
		t1234.setIsLeaf(false);
		
		t12.getChildren().add(t1234);
		
		
		
		
		
		MyTreeModel myTreeModel=new MyTreeModel(root);
		
		MyTreeTreeCellRenderer myTreeTreeCellRenderer=new MyTreeTreeCellRenderer();
		
		jTree.setModel(myTreeModel);
		//jTree.setCellRenderer(myTreeTreeCellRenderer);
		//DefaultTreeCellRenderer
		jTree.setCellRenderer(myTreeTreeCellRenderer);
		
		
		
		jFrame.add(jTree);
		jFrame.setVisible(true);
		
		jFrame.setSize(800, 600);
		
		
	}
	
	

}


class MyTreeModel implements TreeModel{

	private MyTree myTree;
	
	public MyTreeModel(MyTree myTree){
		this.myTree=myTree;
	}
	
	
	public Object getRoot() {
		// TODO Auto-generated method stub
		return myTree;
	}

	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		MyTree m=(MyTree) parent;
		return m.getChildren().get(index);
	}

	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		MyTree m=(MyTree) parent;
		return m.getChildren().size();
	}

	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		MyTree m=(MyTree) node;
		return m.getIsLeaf();
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		System.out.println("valueForPathChanged");
	}

	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		
		
		
		return 0;
	}

	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		System.out.println("addTreeModelListener");
	}

	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		System.out.println("removeTreeModelListener");
	}
	
	
	
	
}



/*class MyTreeTreeCellRenderer implements TreeCellRenderer{

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		// TODO Auto-generated method stub
		
		
		System.out.println("getTreeCellRendererComponent");
		
		
		
		
		return ;
	}
	
	
	
}*/


class MyTree{
	
	private Long id;
	
	private String name;
	
	
	private MyTree parent;
	
	private List<MyTree> children=new ArrayList<MyTree>();
	
	private Boolean isLeaf;
	
	

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyTree getParent() {
		return parent;
	}

	public void setParent(MyTree parent) {
		this.parent = parent;
	}

	public List<MyTree> getChildren() {
		return children;
	}

	public void setChildren(List<MyTree> children) {
		this.children = children;
	}
	
	
	
	
	
	
	
}
