package com.greycampus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertToDb {
	public void insert(GetterSetter gs) {
	  Connection connection=null;
	  PreparedStatement ps =null;
	  
	  try {	  
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##bms","abc");
		 ps = connection.prepareStatement("insert into employee(eno,name,salary,balance,createdby,createdon) values(?,?,?,?,?,?)");
		 java.util.Date utilDate = new java.util.Date();
		 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		 Date b=sqlDate;	
		ps.setInt(1, gs.getEno());
		ps.setString(2, gs.getName());
		ps.setDouble(3, gs.getSalary());
		ps.setDouble(4, gs.getBalance());
		ps.setString(5, gs.getCreatedby());
		ps.setDate(6, b);
		int count = ps.executeUpdate();
		System.out.println("Insert"+count+"values");
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
  }
}
