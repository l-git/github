package com.example.swing.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class EditableTableExample extends JFrame
{
    public EditableTableExample()
    {
        Employee row1 = new Employee(1, "John", 40.0, false);
        Employee row2 = new Employee(2, "Rambo", 70.0, false);
        Employee row3 = new Employee(3, "Zorro", 60.0, true);
         
        //build the list
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(row1);
        employeeList.add(row2);
        employeeList.add(row3);
         
        //create the model
        EmployeeTableModel model = new EmployeeTableModel(employeeList);
        //create the table
        JTable table = new JTable(model);
        
        
        
        
        
        JComboBox jComboBox=new JComboBox(new String[]{"one","two","three"});
        
        jComboBox.setEditable(false);
        
        
        
        jComboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				JComboBox c=(JComboBox) e.getSource();
				System.out.println(c.getSelectedItem());
				
				
			}
        	
        });
        
        
        
        TableColumnModel tableColumnModel=table.getColumnModel();
        
        TableColumn tableColumn=tableColumnModel.getColumn(4);
        tableColumn.setCellEditor(new DefaultCellEditor(jComboBox));
        
        
        
        
        
        
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Editable Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditableTableExample();
            }
        });
    }   
}