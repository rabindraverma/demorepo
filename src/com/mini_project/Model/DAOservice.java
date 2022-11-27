package com.mini_project.Model;

import java.sql.ResultSet;

public interface DAOservice {
	public void connectDB();

	public boolean verifyCredentials(String email, String password);

	public void saveReg(String name, String city, String email, String mobile);

	public ResultSet getReg();

	public void deleteReg(String email);

	public void updateReg(String email, String mobile);

	public boolean verifyEmail(String email);

	
}
