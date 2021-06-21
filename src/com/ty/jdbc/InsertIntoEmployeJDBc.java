package com.ty.jdbc;

import java.sql.*;
import java.sql.DriverManager;

public class InsertIntoEmployeJDBc {
	public static void main(String[] args) {
		Employee e1=new Employee();
		
		Connection con=null;
		Statement s=null;
		ResultSet rs=null;
		
		try {
			String dburl="jdbc:mysql://localhost:3306/employee_info";
			con=DriverManager.getConnection(dburl, "root", "root");
			
			String query="select * from employeedata where eid=2;";
			s=con.createStatement();
			rs=s.executeQuery(query);
			
			while(rs.next()) {
				e1.setId(rs.getInt("eid"));
				e1.setName(rs.getString("ename"));
				e1.setSalary(rs.getInt("esal"));
}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(e1.getId()+" "+e1.getName()+" "+e1.getSalary());
	}
	

}
