package com.ty.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import java.sql.PreparedStatement;

public class InsertDynamically {
	public static void main(String[] args) throws IOException, SQLException {
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties p=new Properties();
		p.load(fis);
		
		Connection c=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		c=DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pass"));
		
		String query="insert into employeedata values(?,?,?);";
		s=c.prepareStatement(query);
		s.setInt(1, Integer.parseInt(args[0]));
		s.setString(2, args[1]);
		s.setInt(3, Integer.parseInt(args[2]));
		
		int n=s.executeUpdate();
		

		
	}

}
