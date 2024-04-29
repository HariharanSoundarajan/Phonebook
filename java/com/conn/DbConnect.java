package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection conn;
	public static Connection getConn() 
	{
		String url="jdbc:mysql://localhost:3306/phonebook";
		String userName="root";
		String passWord="Thor@55";
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,userName,passWord);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	 
}
