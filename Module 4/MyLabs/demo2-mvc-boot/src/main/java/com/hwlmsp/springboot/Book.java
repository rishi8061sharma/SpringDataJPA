package com.hwlmsp.springboot; 
	/* 
	* @Author : Srinivas Dande 
	* @Company: Java Learning Center 
	* */ 
	public class Book { 
	 private int bid; 
	 private String bname; 
	 private String author; 
	 private double price; 
	 private String pub; 
	 
	 public Book() {} 
	 public Book(int bid, String bname, String author, double price, String pub) { 
	 super(); 
	 this.bid = bid; 
	 this.bname = bname; 
	 this.author = author; 
	 this.price = price; 
	 this.pub = pub; 
	 }
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", price=" + price + ", pub=" + pub
				+ "]";
	} 
	
	
}
