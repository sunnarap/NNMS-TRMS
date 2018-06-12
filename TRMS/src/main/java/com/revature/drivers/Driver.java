package com.revature.drivers;

import java.sql.SQLException;

import com.revature.daoimpl.UserDAOImpl;

public class Driver {

	public static void main(String[] args) {

		UserDAOImpl udi = new UserDAOImpl();
		try {
			udi.createUser("Bob", "Ross", "bob.ross@revature.com", "password1", 1);
			//udi.updateUser("bob.ross@revature.com", 2);
			//System.out.println(udi.retrieveUser("bob.ross@revature.com").toString());
			//udi.deleteUser("bob.ross@revature.com");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
