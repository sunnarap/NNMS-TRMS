package com.revature.drivers;

import java.sql.SQLException;

import com.revature.daoimpl.ReimbursementsDAOimpl;
import com.revature.daoimpl.UserDAOImpl;

public class Driver {

	public static void main(String[] args) {

		UserDAOImpl udi = new UserDAOImpl();

			ReimbursementsDAOimpl rdi = new ReimbursementsDAOimpl();
			try {
//				udi.createUser("Bob", "Ross", "bob.ross@revature.com", "password1", 1);
//				udi.createUser("Boss", "Ross", "boss.ross@revature.com", "admin1", 6);
//				udi.updateUser("bob.ross@revature.com", 2);
//				System.out.println(udi.retrieveUser("bob.ross@revature.com").toString());
//				udi.deleteUser("bob.ross@revature.com");
//				rdi.createReimbursement("PBS", 420.69, "PENDING", "PAINTING CLASS",
//						"I'M BOB ROSS", 5, udi.retrieveUser("bob.ross@revature.com").getUserId(), 63);
				System.out.println(rdi.retrieveReimbursement(5).toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
