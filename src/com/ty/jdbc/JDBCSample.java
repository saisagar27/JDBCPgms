package com.ty.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCSample {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		//Class.for
		
		
		String dburl="jdbc:mysql://localhost:3306/employee_info";
		con=DriverManager.getConnection(dburl, "root", "root");
		
		String query="select * from employeedata;";
		st=con.createStatement();
		rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt("eid"));
			System.out.println(rs.getString("ename"));
			System.out.println(rs.getInt("esal"));
		}
		con.close();
		rs.close();
		st.close();
		
			
		
		
		
	}

}
