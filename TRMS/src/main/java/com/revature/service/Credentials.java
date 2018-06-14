package com.revature.service;
import java.sql.SQLException;

import com.revature.daoimpl.*;

public class Credentials {
	
	private String[] arr;
	private UserDAOImpl udi;
	
	public Credentials(String[] arr)
	{
		this.arr = arr;
		udi = new UserDAOImpl(arr);

	}
	
	public boolean register(String firstname, String lastname, String email, String password)
	{
		
		try {
			udi.createUser(firstname, lastname, email, password, 1);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
