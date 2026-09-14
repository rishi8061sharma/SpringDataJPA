package com.hwlmsp.springboot;

public class TxInfo {

	private int accno; 
	
	private double amount;
	
	public TxInfo() {}
	
	public TxInfo(int accno, double amount) { 
	super(); 
	this.accno = accno; 
	this.amount = amount; 
	}
	
	

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}
