package com.mini_project.Model;

import java.sql.*;

public class DAOServiceImpl implements DAOservice {

	private Connection con;
	private Statement stmnt;
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "test");
			stmnt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "'");
			return result.next();
			System.out.println("hello");

		} catch (Exception e) {
		}

		return false;
	}
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate(
					"insert into registration values('" + name + "','" + city + "','" + email + "','" + mobile + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ResultSet getReg() {
		try {
			
						ResultSet result = stmnt.executeQuery("select * from registration");
						return result;
			
					} catch (Exception e) {
						e.printStackTrace();
					}
			
					return null;
	}
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void updateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("UPDATE registration set mobile='"+mobile+"' where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
	}
	public boolean verifyEmail(String email) {
		try {
			ResultSet result = stmnt
					.executeQuery("select * from login where email='" + email + "'");
			return result.next();

		} catch (Exception e) {
		}
		
		return false;
	}
	
}
