package com.revature.beans;

import java.sql.Timestamp;

public class Reimbursements {
	
	private int rId;
	private String location;
	private Timestamp submit;
	private Timestamp finished;
	private double amount;
	private String status;
	private int cId;
	private int userId;
	private int worker;
	
	public Reimbursements() {
		super();
	}

	public Reimbursements(int rId, String location, Timestamp submit, Timestamp finished, double amount, String status,
			int cId, int userId, int worker) {
		super();
		this.rId = rId;
		this.location = location;
		this.submit = submit;
		this.finished = finished;
		this.amount = amount;
		this.status = status;
		this.cId = cId;
		this.userId = userId;
		this.worker = worker;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getSumbit() {
		return submit;
	}

	public void setSumbit(Timestamp sumbit) {
		this.submit = sumbit;
	}

	public Timestamp getFinished() {
		return finished;
	}

	public void setFinished(Timestamp finished) {
		this.finished = finished;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getWorker() {
		return worker;
	}

	public void setWorker(int worker) {
		this.worker = worker;
	}

	@Override
	public String toString() {
		return "Reimbursements [rId=" + rId + ", location=" + location + ", submit=" + submit + ", finished=" + finished
				+ ", amount=" + amount + ", status=" + status + ", cId=" + cId + ", userId=" + userId + ", worker="
				+ worker + "]";
	}
	
	
	
	
	
	
	

}
