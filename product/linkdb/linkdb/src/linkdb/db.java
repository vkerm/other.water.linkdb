package linkdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class db {
	public  String getName() {
	    Connection conn = getConn();
	    PreparedStatement pstmt;
	    String name="";
	    try {
	    	List<String> ips = iputils.getIp();
	    	String where =" '+1+',";
	    	for(String str:ips) {
	    		where = where+str+",";
	    	};
	    	where =where+ "'+2+'";
	 	    String sql = "select name from ipmessage where ip in ("+where+")";
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	       
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	            	name = rs.getString(i);
	             }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return name;
	}
	private  Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/waterlocation?useUnicode=true&amp;characterEncoding=utf8";
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
