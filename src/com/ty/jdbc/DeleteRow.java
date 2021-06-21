package com.ty.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

public class DeleteRow {
	public static void main(String[] args) throws SQLException, IOException {
		Connection con=null;
		Statement s=null;
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties p=new Properties();
		p.load(fis);
		con=DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"),p.getProperty("pass"));
		
		String query="delete from employeedata where eid=1;";
		s=con.createStatement();
		int n=s.executeUpdate(query);
		System.out.println(n+ " rows affected");
		
		
	}

}
