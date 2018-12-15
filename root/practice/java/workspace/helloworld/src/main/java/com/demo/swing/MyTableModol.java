package com.demo.swing;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MyTableModol  extends AbstractTableModel{

	boolean DEBUG=true;
	List<Person> personList;
	
	List<String> columnName;
	
	public MyTableModol(){
		
		personList=new ArrayList<Person>();
		personList.add(new Person("1","n1",true));
		personList.add(new Person("2","n2",false));
		
		personList.add(new Person("3","n3",true));
		
		personList.add(new Person("4","n4",true));
		
		personList.add(new Person("5","n5",false));
		
		
		
		columnName=new ArrayList<String>();
		columnName.add("h1");
		columnName.add("h2");
		columnName.add("h3");
		
	}
	
	 public String getColumnName(int column) {
		 return columnName.get(column);
	 }
	
	 
	 public Class getColumnClass(int c) {
	      return getValueAt(0, c).getClass();
	    }
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.size();
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return personList.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Person p=personList.get(rowIndex);
		if(columnIndex==0){
			return p.getId();
		}else if(columnIndex==1){
			return p.getName();
		}else if(columnIndex==2){
			return p.getSmoke();
		}else{
			return "================";
		}
	}
	
	
	  public boolean isCellEditable(int row, int col) {
	      //Note that the data/cell address is constant,
	      //no matter where the cell appears onscreen.
	      return true;
	    }
	
	 public void setValueAt(Object value, int row, int col) {
	      if (DEBUG) {
	        System.out.println("Setting value at " + row + "," + col
	            + " to " + value + " (an instance of "
	            + value.getClass() + ")");
	      }

	      personList.get(row).setSmoke((Boolean) (value));
	      
	      //data[row][col] = value;
	      fireTableCellUpdated(row, col);

	      if (DEBUG) {
	        System.out.println("New value of data:");
	        
	      }
	    }
	
	
	public static void main(String args[]){
		System.out.println("main");
		 //JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame frame=new JFrame("table");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 String head[]={"1","2","3"};
		 
		 
		 /*DefaultTableColumnModel cm = new DefaultTableColumnModel() {
		      boolean first = true;

		      public void addColumn(TableColumn tc) {
		        // Drop the first column . . . that'll be the row header
		        if (first) {
		          first = false;
		          return;
		        }
		        tc.setMinWidth(150); // just for looks, really...
		        super.addColumn(tc);
		      }
		    };*/
		 
		 
		 
		 JTable t=new JTable(new MyTableModol());
		 /*t.setPreferredScrollableViewportSize(new Dimension(500, 70));
		 JScrollPane scrollPane = new JScrollPane(t);
		 frame.add(scrollPane);*/
		 
		
		 t.setPreferredScrollableViewportSize(new Dimension(500, 700));
		 JScrollPane scrollPane = new JScrollPane(t);
		 frame.add(scrollPane);
		
		 frame.pack();
		    frame.setVisible(true);
		
		
		
		
		
		
		
		
		
	}

}

class MyTableColumnModel implements TableColumnModel{

	List<String> columnList;
	public MyTableColumnModel(){
		columnList=new ArrayList<String>();
		
		columnList.add("c1");
		columnList.add("c2");
		columnList.add("c3");
		
	}
	
	
	public void addColumn(TableColumn aColumn) {
		// TODO Auto-generated method stub
		
	}

	public void removeColumn(TableColumn column) {
		// TODO Auto-generated method stub
		
	}

	public void moveColumn(int columnIndex, int newIndex) {
		// TODO Auto-generated method stub
		
	}

	public void setColumnMargin(int newMargin) {
		// TODO Auto-generated method stub
		
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnList.size();
	}

	public Enumeration<TableColumn> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getColumnIndex(Object columnIdentifier) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TableColumn getColumn(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getColumnMargin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnIndexAtX(int xPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTotalColumnWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setColumnSelectionAllowed(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	public boolean getColumnSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	public int[] getSelectedColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSelectedColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSelectionModel(ListSelectionModel newModel) {
		// TODO Auto-generated method stub
		
	}

	public ListSelectionModel getSelectionModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}

	public void removeColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}
	
}
