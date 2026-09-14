package com.hwlmsp.springboot;
import java.io.Serializable; 
/* 
 * @Author : Rishi Sharma
 * @company : HWL Advanced Technology Private Limited
 * */ 
public class Order implements Serializable{ 
	private Integer orderId; 
	private String userId; 
	private int totalQty; 
	private double totalCost;
	
	
	public Order() {
		super();
	}


	public Order(Integer orderId, String userId, int totalQty, double totalCost) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
	}


	public Order(String userId, int totalQty, double totalCost) {
		super();
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getTotalQty() {
		return totalQty;
	}


	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", totalQty=" + totalQty + ", totalCost="
				+ totalCost + "]";
	} 
	
	
	
} 