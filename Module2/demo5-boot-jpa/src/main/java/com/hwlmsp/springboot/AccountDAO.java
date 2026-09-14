package com.hwlmsp.springboot;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface AccountDAO {
	
	public double getBalance(int accno);
	public void deposit(int accno, double amount);
	public void withdraw(int accno, double amount);
	public void fundsTransfer(int saccno, int daccno, double amount);
	
}
