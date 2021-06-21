package com.ty.jdbc;

import java.sql.*;

public class InsertStatuc {
	public static void main(String[] args) {
		Connection c=null;
		Statement s=null;
		
		
		try {
			String dburl="jdbc:mysql://localhost:3306/employee_info";
			c=DriverManager.getConnection(dburl, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			String query="insert into employeedata values(1,'sagar',20000);";
			s=c.createStatement();
			int n=s.executeUpdate(query);
			System.out.println(n+" rows affected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
