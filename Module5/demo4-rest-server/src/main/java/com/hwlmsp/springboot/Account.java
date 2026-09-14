package com.hwlmsp.springboot;

import javax.persistence.*; 
@Entity 
@Table(name = "myaccounts") 
public class Account { 
	
	@Id 
	@Column(name = "accno") 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int accno; 
	
	@Column(name = "atype") 
	private String atype; 
	
	@Column(name = "bcode") 
	private String bcode; 
	
	@Column(name = "balance") 
	private double balance; 
	
	@Column(name="city") 
	private String city; 
	
	public Account() {} 
	
	public Account( String atype, String bcode, double balance, String city) { 
		super(); 
		this.atype = atype; 
		this.bcode = bcode; 
		this.balance = balance; 
		this.city = city; 
	} 
	
	public Account(int accno, String atype, String bcode, double balance, String city) { 
		super(); 
		this.accno = accno; 
		this.atype = atype; 
		this.bcode = bcode; 
		this.balance = balance; 
		this.city = city; 
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "[" + accno  + atype +  bcode  + balance +  city + "]";
	}
	
	

}