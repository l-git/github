package com.company.jdbc;

import org.apache.log4j.Logger;

import java.sql.*;

public class DbUtil {


    private static Logger logger=Logger.getLogger(DbUtil.class);

    public static final String URL = "jdbc:mysql://localhost:3306/a";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM t_system_users");
        //如果有数据，rs.next()返回true


        ResultSetMetaData resultSetMetaData =rs.getMetaData();

        int columnCount=resultSetMetaData.getColumnCount();

        for(int i = 1; i <= columnCount; ++i) {

            String s=resultSetMetaData.getColumnLabel(i);
            String s1=resultSetMetaData.getColumnName(i);
            String s2=resultSetMetaData.getColumnClassName(i);


            logger.debug("---------------------------------");
            logger.debug(s);
            logger.debug(s1);
            logger.debug(s2);
            logger.debug("===============================");



        }



    }
}
