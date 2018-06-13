
package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.User;

/**
 * Data access object for employee/user accounts.
 * @author Nathaniel Simpson
 *
 */
public interface UserDAO {
	
	/*
	 * Create and put a new user in a database
	 */
	public abstract void createUser(String fName,String lName,
			String email, String password, int tid) throws SQLException;
	
	/*
	 * Retrieve a user from the database
	 */
	public abstract User retrieveUser(String email) throws SQLException;
	
	/*
	 * Update a user in the database. Unsure of what to do here.
	 */
	public abstract void updateUser(String email) throws SQLException;
	
	/*
	 * Deletes a user from the database.
	 */
	public abstract void deleteUser(String email) throws SQLException;

}