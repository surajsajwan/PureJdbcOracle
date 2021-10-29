package com.greycampus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateToDb {
	public void update(GetterSetter gs) {
		 java.util.Date utilDate = new java.util.Date();
		 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		 Date b=sqlDate;
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			ps = connection.prepareStatement("update employee set updatedby=?,updatedon=? where eno=?");
			ps.setString(1, gs.getUpdatedby());
			ps.setDate(2, b);
			ps.setInt(3, gs.getEno());
			int count = ps.executeUpdate();
			System.out.println("Updated" + count + "values");
		} catch (Exception e) {
			System.out.println("Error in update code");
		} finally {
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
