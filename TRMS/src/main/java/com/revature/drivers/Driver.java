package com.revature.drivers;

import java.sql.SQLException;

import com.revature.daoimpl.UserDAOImpl;

public class Driver {

	public static void main(String[] args) {
		UserDAOImpl udi = new UserDAOImpl();
		try {
			udi.createUser("Bob", "Ross", "bob.ross@gmail.gov", "happytrees1", 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
