package com.ty.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ShowDynamically {

	public static void main(String[] args) throws IOException, SQLException {
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties p=new Properties();
		p.load(fis);
		
		
		
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet r=null;
		
		con=DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pass"));
		String query="select * from employeedata where eid=?;";
		ps=con.prepareStatement(query);
		ps.setInt(1, Integer.parseInt(args[0]));
		r=ps.executeQuery();
		
		while(r.next()) {
			System.out.println(r.getInt("eid"));
			System.out.println(r.getString("ename"));
			System.out.println(r.getInt("esal"));
			
		}
		
		
	}
}
