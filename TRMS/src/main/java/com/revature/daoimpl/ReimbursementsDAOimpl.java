package com.revature.daoimpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.beans.Reimbursements;
import com.revature.dao.ReimbursementsDAO;
import com.revature.util.ConnFactory;

/**
 * Data access object implementation for accessing, editing, and
 * manipulating reimbursement data.
 * @author Marcus Aderele
 *
 * Modified by Nathaniel Simpson
 */

public class ReimbursementsDAOimpl implements ReimbursementsDAO {

	//Connection factory object for connecting to the database
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	/*
	 * Create and put a new reimbursement/form data in database
	 * 
	 * Reformatted into a callable statement
	 */
	public void createReimbursement(String location,
			double amount, String status, String desc, String justification,
			int cId, int userId, int worker) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "{call CREATE_REIMBURSEMENT(?,?,?,?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, location);
		call.setDouble(2, amount);
		call.setString(3, status);
		call.setString(4, desc);
		call.setString(5, justification);
		call.setInt(6, cId);
		call.setInt(7, userId);
		call.setInt(8, worker);
		call.execute();
		conn.close();
	}

	/*
	 * Retrieve reimbursement/form details from the database
	 */
	public Reimbursements retrieveReimbursement(int rId) throws SQLException {
		
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "RID";
		String sql = "SELECT * FROM REIMBURSEMENT WHERE RID = ?";
		
		ResultSet rs = null;
		Reimbursements r = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setInt(1, rId);
			rs = ps.executeQuery();
			if(rs.next())
			{
				r = new Reimbursements(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getTimestamp(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12));
				conn.close();
				return r;
			}
			
		}catch(SQLException e) {
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
		String sql = "UPDATE REIMBURSEMENT SET FINISHED = ? WHERE RID = ?";
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
		String sql = "{call DELETE_REIMBURSEMENT(?)";
		
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, rId);
			cs.execute();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}