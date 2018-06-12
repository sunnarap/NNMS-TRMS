package com.revature.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.beans.Reimbursements;
import com.revature.beans.User;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

/**
 * Data access object implementation for accessing, editing, and
 * manipulating reimbursement data.
 * @author Marcus Aderele
 *
 */

public class ReimbursementsDAOimpl implements ReimbursementsDAO {

	//Connection factory object for connecting to the database
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	/*
	 * Create and put a new reimbursement/form data in database
	 */
	public void createReimbursement(String location, Timestamp submit, Timestamp finished, double amount, String status,
			int cId, int userId, int worker) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = 
				"INSERT INTO REIMBURSEMENT VALUES(RIDSEQUENCE.NEXTVAL,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, location);
			ps.setTimestamp(2, submit);
			ps.setTimestamp(3, finished);
			ps.setDouble(4, amount);
			ps.setString(5, status);
			ps.setInt(6, cId);
			ps.setInt(7, userId);
			ps.setInt(8, worker);

			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		
	}

	/*
	 * Retrieve reimbursement/form details from the database
	 */
	public Reimbursements retrieveReimbursement(int rId) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERS WHERE RID = '?'";
		
		ResultSet rs = null;
		Reimbursements r = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rId);
			rs = ps.executeQuery();
			if(rs.next())
			{
				r = new Reimbursements(rs.getInt(1), rs.getString(2), rs.getTimestamp(3),
						rs.getTimestamp(4), rs.getDouble(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				conn.close();
				return r;
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	
	//---------------------------UPDATES--------------------------------------------
	/*
	* Update reimbursement info in the database
	*/
	//update Status
	public void updateReimbursementStatus(int rId, String status) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENT SET STATUS = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}
	}

	//update Amount
	public void updateReimbursementAmount(int rId, Double amt) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENT SET AMOUNT = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amt);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}

	}

	//update current worker
	public void updateReimbursementWorker(int rId, int worker) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "UPDATE REIMBURSEMENT SET WORKER = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, worker);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}


	}

	//updateFinishTime
	public void updateReimbursementFinishTime(int rId, Timestamp time) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENT SET time = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, time);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}


	}

	public void deleteReimbursement(int rId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM REIMBURSEMENTS WHERE RID = '?'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rId);
			ps.execute();
			conn.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
