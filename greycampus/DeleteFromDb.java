package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFromDb {
   public void delete(GetterSetter gs) {
	   Connection connection=null;
		  PreparedStatement ps =null;
		  try {	  
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##bms","abc");
			 ps = connection.prepareStatement("delete from employee where eno=?");
			ps.setInt(1, gs.getEno());
			int count = ps.executeUpdate();
			System.out.println("Delete"+count+"values");
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
