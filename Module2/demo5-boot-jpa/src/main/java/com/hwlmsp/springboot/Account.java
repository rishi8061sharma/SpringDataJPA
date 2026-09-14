package com.hwlmsp.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myaccounts")
public class Account {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="accno")
 private int accno;
 
 @Column(name="atype")
 private String atype;
 
 @Column(name="balance")
 private double balance;

 public Account() {
		
 }
 
 public Account(String atype, double balance) {
		this.atype = atype;
		this.balance = balance;
	}

 public Account(int accno, String atype, double balance) {
	this.accno = accno;
	this.atype = atype;
	this.balance = balance;
 }

@Override
public String toString() {
	return "Account [=" + accno + ", =" + atype + ", =" + balance + "]";
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

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
 

}
