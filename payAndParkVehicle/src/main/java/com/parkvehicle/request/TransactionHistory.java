package com.parkvehicle.request;

public class TransactionHistory {

	private long transid;
	private long userid;
	private Double amount;
	private String cardno;
	private java.sql.Timestamp transdate;

	public long getTransid() {
		return transid;
	}

	public void setTransid(long transid) {
		this.transid = transid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public java.sql.Timestamp getTransdate() {
		return transdate;
	}

	public void setTransdate(java.sql.Timestamp transdate) {
		this.transdate = transdate;
	}

	

	
	
}
