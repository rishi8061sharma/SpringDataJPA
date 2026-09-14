package com.hwlmsp.springboot;

import javax.persistence.*;

import org.hibernate.annotations.NamedNativeQueries;

@Entity
@Table(name="mycustomers")
@NamedQuery(name="customerByCity-A",
            query="from Customer cust where cust.city=:mycity")
@NamedNativeQuery(name="customerByCity-B",
                  query="select * from mycustomers cust where cust.city=?1",
                  resultClass = Customer.class)
                   
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
	
	public Customer(){
		
	}
	
	public Customer(String cname, String email, int phone, String city) {
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}

	public Customer(int cid, String cname, String email, int phone, String city) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
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

	@Override
	public String toString() {
		return "[" + cid + "," + cname + "," + email + "," + phone + "," + city
				+ "]";
	}
	
	
}
