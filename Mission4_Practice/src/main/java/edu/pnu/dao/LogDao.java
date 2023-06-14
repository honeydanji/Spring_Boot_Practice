package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class LogDao {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/mission2";
	private String username = "scott";
	private String password = "tiger";

	private Connection con;
	
	public LogDao() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
