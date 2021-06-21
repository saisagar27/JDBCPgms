package com.ty.jdbc;

import java.io.*;
import java.util.*;
import java.sql.*;

public class UpdateRow {
	public static void main(String[] args) throws IOException, SQLException {
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties p=new Properties();
		p.load(fis);
		
		Connection con=null;
		Statement st=null;
		
		con=DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pass"));
		
		String query="update employeedata set ename='raju',esal=15000,eid=3 where eid=1; ";
		st=con.createStatement();
		int n=st.executeUpdate(query);
		System.out.println(n+" rows updated");
	}

}
