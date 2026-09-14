package com.hwlmsp.springboot;

import javax.persistence.*;
@Entity 
@Table(name="mycustomers") 
public class Customer { 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="cid") 
	private int cid; 
	@Column(name="cname") 
	private String cname; 
	@Column(name="email") 
	private String email; 
	@Column(name="phone") 
	private int phone; 
	@Column(name="city") 
	private String city; 
	@Column(name="balance") 
	private double balance; 
	public Customer() {} 
	public Customer(String cname, String email, int phone, String city,double balance) { 
		this.cname = cname; 
		this.email = email; 
		this.phone = phone; 
		this.city = city; 
		this.balance=balance; 
	} 
	public Customer(int cid, String cname, String email, int phone, String city,double balance) { 
		this.cid = cid; 
		this.cname = cname; 
		this.email = email; 
		this.phone = phone; 
		this.city = city; 
		this.balance=balance; 
	} 

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "[" + cid + "," + cname + "," + email + "," + phone + "," + city
				+ "]";
	}


}
