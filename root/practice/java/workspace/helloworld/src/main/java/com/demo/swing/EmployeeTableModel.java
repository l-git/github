package com.demo.swing;

import java.util.List;
import javax.swing.table.AbstractTableModel;
 

 
public class EmployeeTableModel extends AbstractTableModel
{
    private final List<Employee> employeeList;
     
    private final String[] columnNames = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time","combo"
    };
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, Double.class, Boolean.class,String.class
    };
 
    public EmployeeTableModel(List<Employee> employeeList)
    {
        this.employeeList = employeeList;
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    
    public int getRowCount()
    {
        return employeeList.size();
    }
 
   
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Employee row = employeeList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getId();
        }
        else if(1 == columnIndex) {
            return row.getName();
        }
        else if(2 == columnIndex) {
            return row.getHourlyRate();
        }
        else if(3 == columnIndex) {
            return row.isPartTime();
        }else if(4== columnIndex){
        	return row.getCombo();
        }
        return null;
    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Employee row = employeeList.get(rowIndex);
        if(0 == columnIndex) {
            row.setId((Integer) aValue);
        }
        else if(1 == columnIndex) {
            row.setName((String) aValue);
        }
        else if(2 == columnIndex) {
            row.setHourlyRate((Double) aValue);
        }
        else if(3 == columnIndex) {
            row.setPartTime((Boolean) aValue);
        }else if(4==columnIndex){
        	row.setCombo((String) aValue);
        }
    }
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
}
