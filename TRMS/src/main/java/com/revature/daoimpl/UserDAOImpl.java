package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

/**
 * Data access object implementation for accessing, editing, and
 * manipulating user accounts and data.
 * @author Nathaniel Simpson
 *
 */
public class UserDAOImpl implements UserDAO {
	
	//Connection factory object for connecting to the database
	public static ConnFactory cf = ConnFactory.getInstance();

	
	public void createUser(String fName, String lName, 
			String email, String password, int tid) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "{call CREATE_USER(?,?,?,?,?)";
		
		System.out.println("Begin call");
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, fName);
		call.setString(2, lName);
		call.setString(3, email);
		call.setString(4, password);
		call.setInt(5, tid);
		call.execute();
		conn.close();
		
		System.out.println("Call complete");
		
	}

	
	public User retrieveUser(String email) throws SQLException {
		
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "SELECT * FROM USERS WHERE EMAIL = '?'";
		
		ResultSet rs = null;
		User user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql,primaryKeys);
			ps.setString(1, email);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6));
			conn.close();
			return user;
		}
		
		return null;

	}

	
	public void updateUser(String email) throws SQLException {
		// TODO Auto-generated method stub

	}

	
	public void deleteUser(String email) throws SQLException {
		
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "DELETE FROM USERS WHERE EMAIL = '?'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setString(1, email);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}