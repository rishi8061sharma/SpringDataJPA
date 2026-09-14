package com.hwlmsp.springboot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mycustomers")
public class Customer {
	
	@Id
	private String myobjectId;
	
	@Indexed
    private int cid;
    private String cname;
    private String email;
    private int phone;
    private String city;
    private double balance;
	
	public Customer() {
	
	}

   public Customer(int cid, String cname, String email, int phone, String city, double balance) {
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.balance = balance;
	}

   
   
  public String getMyobjectId() {
	return myobjectId;
}

public void setMyobjectId(String myobjectId) {
	this.myobjectId = myobjectId;
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
		return "["+myobjectId + cid + "," + cname + "," + email + "," + phone + "," + city
				+ ","+balance+"]";
	}
	
	
}
