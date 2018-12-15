package com.demo.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;

//special one table

public class DBMetadataTable {

	
	static final String equal="=";
	static final String space=" ";
	static final String and = "and";
	static final String notEqual = "!=";
	//Single Quotation Marks Versus Double Quotation Marks
	static final String SingleQuotation="'";
	static final String SingleQuotationDouble="''";
	
	static final String DoubleQuotation="\"";
	static final String DoubleQuotationDouble="\"\"";
	
	
	static final String rn="\r\n";
	static final String numSign="#";
	static final String comma=",";
	static final String leftBrace="{";
	static final String rightBrace="}";
	
	
	static final String jdbcType="jdbcType";
	
	static final Map<String, String> ConstantFieldValuesMap = new HashMap<String, String>();
	
	
	static final Map<String, String> jdbcTypeMap = new HashMap<String, String>();

	static {

		ConstantFieldValuesMap.put("12", "VARCHAR");
		ConstantFieldValuesMap.put("93", "TIMESTAMP");
		ConstantFieldValuesMap.put("2", "NUMERIC");
		ConstantFieldValuesMap.put("4", "INTEGER");
		ConstantFieldValuesMap.put("2005", "CLOB");
		ConstantFieldValuesMap.put("16", "BOOLEAN");
		ConstantFieldValuesMap.put("2004", "BLOB");
		ConstantFieldValuesMap.put("-5", "BIGINT");
		ConstantFieldValuesMap.put("-4", "LONGVARBINARY");
		ConstantFieldValuesMap.put("-4", "LONGVARBINARY");
		ConstantFieldValuesMap.put("-1", "LONGVARCHAR");
		
		
		
		
		
		
		/*jdbcTypeMap.put("4", "NUMERIC");
		jdbcTypeMap.put("-5", "NUMERIC");
		jdbcTypeMap.put("12", "VARCHAR");
		jdbcTypeMap.put("93", "TIMESTAMP");
		jdbcTypeMap.put("", "NUMERIC");
		jdbcTypeMap.put("", "NUMERIC");*/
		
		
		
		
		
		
		

	}

	public static void main(String args[]) {

		String tableName=null;
		
		tableName="t_users";
		

		String url = "jdbc:mysql://localhost:3306/a";
		String username = "root";
		String password = "root";
		
		url = "jdbc:mysql://localhost:3306/test";
		username = "root";
		password = "root";
		
		
		
		
		
		Map<String,Object> container=new HashMap<String,Object>();
		
		
		Connection connection = getConnection(url, username, password);

		DatabaseMetaData databaseMetaData = getDatabaseMetaData(connection);
		
		List<String> columnList =new ArrayList<String>();
		List<String> columnTypeList =new ArrayList<String>();
		List<String> columnTypeJavaList =new ArrayList<String>();
		
		getRelationSchema(databaseMetaData,tableName,columnList,columnTypeList,columnTypeJavaList);
		
		
		container.put(tableName,columnList );
		
		List<String> column=new ArrayList<String>();
		List<String> camelColumn=new ArrayList<String>();
		
		getColumnAndCamelColumn(container,tableName,column,camelColumn);
		
		select(column,camelColumn);
		
		where(column,camelColumn);
		
		//whereMap(column,camelColumn,columnTypeList);
		
		insert(column,camelColumn);
		
		values(column,camelColumn);
		
		update(column,camelColumn);
				
		bean(column,camelColumn);
		
		
		
		
		
		
		
		

	}

	static void getRelationSchema(DatabaseMetaData databaseMetaData,
			String tableNamePattern,
			List<String> columnList,
			List<String> columnTypeList,
			List<String> columnTypeJavaList
			){
		
		String   catalog           = null;
		String   schemaPattern     = null;
		//String   tableNamePattern  = "my_table";
		String   columnNamePattern = null;


		ResultSet result = null;
		try {
			result = databaseMetaData.getColumns(
			    catalog, schemaPattern,  tableNamePattern, columnNamePattern);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			
			/*ResultSetMetaData resultSetMetaData =result.getMetaData();
			
			int columnCount=resultSetMetaData.getColumnCount();
			
			for(int i=1;i<=columnCount;i++){
				
				int columnType=resultSetMetaData.getColumnType(i);
				
				String columnClassName=resultSetMetaData.getColumnClassName(i);
				
				String columnLabel=resultSetMetaData.getColumnLabel(i);
				
				String columnName=resultSetMetaData.getColumnName(i);
				
				String columnTypeName=resultSetMetaData.getColumnTypeName(i);
				
				System.out.println(columnType);
				
				System.out.println(columnClassName);
				System.out.println(columnLabel);
				System.out.println(columnLabel);
				System.out.println(columnName);
				System.out.println(columnTypeName);
				
				section();
				
				
			}*/
			
			
			while(result.next()){
				
			    String columnName = result.getString(4);
			    int    columnType = result.getInt(5);
			    
			    String javaConstant=ConstantFieldValuesMap.get(columnType+"");
			    
			   /* System.out.println(columnName);
			    System.out.println(columnType);
			    System.out.println(javaConstant);
			    
			    section();*/
			    
			    
			    /*if(javaConstant==null){
			    	throw new RuntimeException("unknow columnType:"+columnType);
			    }
			    */
			    
			    
			    columnList.add(columnName);
			    columnTypeList.add(columnType+"");
			    columnTypeJavaList.add("javaConstant");
			    
			    
			    /*System.out.println(columnName);
			    System.out.println(columnType);*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static DatabaseMetaData getDatabaseMetaData(Connection connection) {

		DatabaseMetaData databaseMetaData = null;
		try {
			databaseMetaData = (DatabaseMetaData) connection.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return databaseMetaData;

	}

	static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static Connection getConnection(String url, String username, String password) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}

		// System.out.println("MySQL JDBC Driver Registered!");

		Connection connection = null;

		try {
			connection = (Connection) DriverManager.getConnection(url,
					username, password);

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	
	static void section(int n){
		for(int i=0;i<n;i++){
			System.out.println("");
		}
	}
	
	static void section(){
		section(4);
	}
	
	
	
	static void delimiter(String s){
		
		System.out.println(s+"-----------------------------");
		
	}
	
	
	static void getColumnAndCamelColumn(Map<String,Object> container,
			String tableName,
			List<String> columnList,
			List<String> camelColumnList){
		
		Set<String> keySet=container.keySet();
		
		if(null != tableName && !"".equals(tableName)){
		
			
			for(String key:keySet){
				
				if(key.equals(tableName)){
					List<String> tableColumnList=(List<String>) container.get(tableName);
					
					for(String tableColumn:tableColumnList){
						
						columnList.add(tableColumn);
						
						camelColumnList.add(columnToCamelColumn(tableColumn));
						
						
					}
					
					
					
				}
			
				
			}
		
		}else{
			
			
			
			
			
		}
		
	}
	
	
	
	
	static String columnToCamelColumn(String column){
		String camelColumn=null;
		
		String underscore="_";
		int i = column.indexOf(underscore);
		while (i > -1) {

			char upper = column.charAt(i + 1);

			upper = (char) (upper - 32);
			String s1 = column.substring(i, i + 2);
			column = column.replace(s1, "_" + upper);

			i = column.indexOf("_", i + 1);

		}

		camelColumn = column.replace("_", "");
		
		return camelColumn;
		
	}
	
	

	
	
	static void sql(String tableName){
		
		
		
	}
	
	
	
	
	
	
	
	
	static void select(List<String> column,List<String> camelColumn){
		section();
		delimiter("select");
		for(int i=0;i<column.size();i++){
			
			System.out.println(column.get(i)+" as "+"\""+camelColumn.get(i)+"\",");
			
		}
		
		delimiter("select");
	}
	
	
	
	static void where(List<String> column,List<String> camelColumn){
		
		section();
		delimiter("where");
		String ifStr="<if test=\"";
		String ifStr1=" != null";
		String ifStr2="\">";
		String ifEnd="</if>";
		String rn="\r\n";
		String numSign="#";
		String comma=",";
		String leftBrace="{";
		String rightBrace="}";
		
		String jdbcType="jdbcType";
		
		
		for(int i=0;i<column.size();i++){
			String s="";
			
			s=ifStr+camelColumn.get(i)+ifStr1+ifStr2;
			System.out.println(s);
			System.out.println("	"+"AND "+column.get(i)+" = "+numSign+leftBrace+camelColumn.get(i)+rightBrace);
			System.out.println(ifEnd);
		}
		
		delimiter("where");
		
		
		
	}
	
	
	static void whereMap(List<String> column,List<String> camelColumn,List<String> columnTypeList){
		
		section();
		delimiter("whereMap");
		String ifStr="<if test=\"";
		String ifStr1=" != null";
		String ifStr2="\">";
		String ifEnd="</if>";

		
		for(int i=0;i<column.size();i++){
			String s="";
			
			String jdbcTypeValue=ConstantFieldValuesMap.get(columnTypeList.get(i));
			if(jdbcTypeValue==null){
				throw new RuntimeException("unknow column type:"+columnTypeList.get(i)+",column name:"+column.get(i));
			}
			
			s=ifStr+camelColumn.get(i)+ifStr1+space+and+space+camelColumn.get(i)+space+notEqual+space+SingleQuotationDouble+space+ifStr2;
			
			System.out.println(s);
			System.out.println("	"+"AND "+column.get(i)+" = "+numSign+leftBrace+camelColumn.get(i)+comma+jdbcType+equal+jdbcTypeValue+rightBrace);
			System.out.println(ifEnd);
		}
		
		delimiter("whereMap");
		
	}
	
	
	
	static void insert(List<String> column,List<String> camelColumn){
		section();
		delimiter("insert");
		String ifStr="<if test=\"";
		String ifStr1=" != null";
		String ifStr2="\">";
		String ifEnd="</if>";
		String rn="\r\n";
		String numSign="#";
		String comma=",";
		String leftBrace="{";
		String rightBrace="}";
		
		for(int i=0;i<column.size();i++){
			String s="";
			s=ifStr+camelColumn.get(i)+ifStr1+ifStr2;
			System.out.println(s);
			System.out.println("	"+column.get(i)+",");
			System.out.println(ifEnd);
		}
		
		delimiter("insert");
	}
	
	static void values(List<String> column,List<String> camelColumn){
		section();
		delimiter("values");
		String ifStr="<if test=\"";
		String ifStr1=" != null";
		String ifStr2="\">";
		String ifEnd="</if>";
		String rn="\r\n";
		String numSign="#";
		String comma=",";
		String leftBrace="{";
		String rightBrace="}";
		
		for(int i=0;i<column.size();i++){
			String s="";
			s=ifStr+camelColumn.get(i)+ifStr1+ifStr2;
			System.out.println(s);
			System.out.println("	"+numSign+leftBrace+camelColumn.get(i)+rightBrace+",");
			System.out.println(ifEnd);
		}
		
		delimiter("values");
	}
	
	static void update(List<String> column,List<String> camelColumn){
		section();
		
		delimiter("update");
		String ifStr="<if test=\"";
		String ifStr1=" != null";
		String ifStr2="\">";
		String ifEnd="</if>";
		String rn="\r\n";
		String numSign="#";
		String comma=",";
		String leftBrace="{";
		String rightBrace="}";
		String space=" ";
		String tab="	";
		String equal=" = ";
		
		String set="set";
		
		
		for(int i=0;i<column.size();i++){
			
			String s="";
			
			String s1="";
			String s2="";
			
			s+=ifStr+camelColumn.get(i)+ifStr1+ifStr2;
			System.out.println(s);
			
			s1+=tab+comma+column.get(i)+equal+numSign+leftBrace+camelColumn.get(i)+rightBrace;
			System.out.println(s1);
			
			s2=ifEnd;
			
			System.out.println(s2);
			
			
		}
		
		delimiter("update");
	}
	
	
	
	
	static void bean(List<String> column,List<String> camelColumn){
		section();
		
		delimiter("bean");
		for(int i=0;i<column.size();i++){
			
			System.out.println("private String "+camelColumn.get(i)+";");
			
			
		}
		
		
		delimiter("bean");
	}
	
	
	
	
	
}
