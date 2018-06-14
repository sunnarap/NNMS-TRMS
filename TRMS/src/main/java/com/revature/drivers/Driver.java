package com.revature.drivers;

import java.sql.SQLException;

import com.revature.daoimpl.ReimbursementsDAOimpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.service.Credentials;

public class Driver {

	public static void main(String[] args) {

		UserDAOImpl udi = new UserDAOImpl(args);
		ReimbursementsDAOimpl rdi = new ReimbursementsDAOimpl(args);

		//try {
			//				udi.createUser("Bob", "Ross", "bob.ross@revature.com", "password1", 1);
			//				udi.createUser("Boss", "Ross", "boss.ross@revature.com", "admin1", 6);
			//				udi.updateUser("bob.ross@revature.com", 2);
			//				System.out.println(udi.retrieveUser("bob.ross@revature.com").toString());
			//				udi.deleteUser("bob.ross@revature.com");
//			rdi.createReimbursement("PBS", 2041.23, "PENDING", "OIL PAINTING CLASS",
//					"I'M BOB ROSS", 5, udi.retrieveUser("boss.ross@revature.com").getUserId(), 63);
//			//System.out.println(rdi.retrieveReimbursement(5).toString());
			//System.out.println(rdi.retrieveUserReimbursements(61));

		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}

}
