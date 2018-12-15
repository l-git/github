package com.demo.swing;

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
         
        
        
        
        JComboBox comboBox = new JComboBox(new String[]{"c1","c2","c3"});
        comboBox.setEditable(false);
        DefaultCellEditor editor = new DefaultCellEditor(comboBox);
        
        
        comboBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                JComboBox j=(JComboBox) e.getSource();
               System.out.println(j.getItemAt(j.getSelectedIndex()));
            	System.out.println(j.getSelectedIndex());
            	System.out.println("------------------------------------");
            }
        });
        
        
        
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(4).setCellEditor(editor);
        
        
        
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Editable Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
       /* SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {*/
                new EditableTableExample();
          /*  }
        });*/
    }   
}
