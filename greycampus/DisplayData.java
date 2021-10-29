package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DisplayData {
	public ArrayList<GetterSetter> display() {
		Connection connection = null;
		Statement createStatement = null;
		ArrayList<GetterSetter> al = new ArrayList<GetterSetter>();
		ResultSet eu = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			createStatement = connection.createStatement();
			eu = createStatement.executeQuery("select * from employee");
			while (eu.next()) {
				GetterSetter gs = new GetterSetter();
				gs.setEno(eu.getInt("eno"));
				gs.setName(eu.getString("name"));
				gs.setSalary(eu.getDouble("salary"));
				gs.setBalance(eu.getDouble("balance"));
				gs.setCreatedby(eu.getString("createdby"));
				gs.setCreatedon(eu.getDate("createdon"));
				gs.setUpdatedby(eu.getString("updatedby"));
				gs.setUpdatedon(eu.getDate("updatedon"));
				al.add(gs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				eu.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				createStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}
}
