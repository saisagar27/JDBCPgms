package com.ty.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class UpdateDynamically {
	public static void main(String[] args) throws IOException, SQLException {
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties p=new Properties();
		p.load(fis);
		
		Connection con=null;;
		PreparedStatement ps=null;
		
		con=DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pass"));
		String s="update employeedata set eid=?,ename=?,esal=? where eid=?;";
		ps=con.prepareStatement(s);
		ps.setInt(1,Integer.parseInt(args[0]));
		ps.setString(2,args[1]);
		ps.setInt(3,Integer.parseInt(args[2]));
		ps.setInt(4,Integer.parseInt(args[3]));
		
		int n=ps.executeUpdate();
		
		
		
	}

}
