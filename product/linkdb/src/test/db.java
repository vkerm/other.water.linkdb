package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db {
	public  String getName() {
	    Connection conn = getConn();
	    String sql = "select name from persons";
	    PreparedStatement pstmt;
	    String name="";
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	       
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	            	name = rs.getString(i);
	             }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return name;
	}
	private  Connection getConn() {
	    String driver = "org.mariadb.jdbc.Driver";
	    String url = "jdbc:mariadb://localhost:3306/test";
	    String username = "root";
	    String password = "root";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
}
