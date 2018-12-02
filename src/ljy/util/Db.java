package ljy.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class Db {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/huinong";
    static final String USER = "root";
    static final String PASS = "root";
    
	public static Connection getConnection() {
		Connection conn = null;
		try {
			 Class.forName(JDBC_DRIVER);
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 System.out.println(conn);
		}
		catch(Exception e) {
		   
		}
		return conn;
	}
}
