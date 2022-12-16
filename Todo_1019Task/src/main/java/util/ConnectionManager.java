package util; // test 꺼 똑같이 가져옴.  재..사..용..

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
			catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			
			
			String JDBC_URL = "jdbc:mysql://localhost:3306/todo?characterEncoding=UTF-8&serverTimezone=UTC";
			String JDBC_USER = "root";// 여긴다음에 파일로 가져온다
			String JDBC_PASS= "Coder.Son";// 여긴다음에 파일로 가져온다
			Connection conn = null;
			try {
			conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS); 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return conn; 
	} //getConnection
	
}	//class
