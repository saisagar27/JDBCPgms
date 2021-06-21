package com.ty.jdbc;

import java.io.FileReader;
import java.util.Properties;
import java.sql.*;

public class DeleteDynamically {
	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("properties.properties");
		Properties p=new Properties();
		p.load(fr);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c=null;
		PreparedStatement ps=null;
		
		c=DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pass"));
		String query="delete from employeedata where eid=?;";
		ps=c.prepareStatement(query);
		ps.setInt(1, Integer.parseInt(args[0]));
		ps.executeUpdate();
		
		
	}

}
