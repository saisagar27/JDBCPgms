package com.ty.jdbc;

import java.sql.Connection;
import java.sql.*;

public class ScrollableResultSet {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_info","root","root");
		String db="select * from employeedata;";
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery(db);
//		rs.afterLast();
		rs.absolute(3);
		while(rs.previous()) {
			System.out.println(rs.getInt("eid"));
			System.out.println(rs.getString("ename"));
			System.out.println(rs.getInt("esal"));
			System.out.println("-------------------");
		}
		
	}

}
