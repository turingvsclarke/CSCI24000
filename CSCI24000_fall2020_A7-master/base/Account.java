// Account.java
// This is the Account class. Each account has type, balance, interest rate and withdraw, deposit, showBalance methods

import java.util.*;

public class Account{
	String type;
	double balance;
	double interestRate;

	public Account(String x,double y,double z){
		type = x;
		balance = y;
		interestRate = z;
	} // end constructor

	public static void main(String args[]){
		Account savings = new Account("hi,1000,1");
		System.out.println("Is the amount below a thousand?");
		savings.showBalance();
	} // end main
	
	public Account(String properties){
		String[] props = new String[3];	
		for(int i=0;i<3;i++){
			int index = properties.indexOf(',');
			if(index<0){
				props[i]=properties;
				break;
			}
			props[i] = properties.substring(0,index);
			properties = properties.substring(index+1);
		}
		type = props[0];
		balance = Double.parseDouble(props[1]);
		interestRate = Double.parseDouble(props[2]);

	}; // end constructor

	public String getProps(){
		return type+","+balance+","+interestRate;
	}

	public void withdraw(double withdrawAmount){
		if(withdrawAmount>balance){
			System.out.println("Insufficient funds");
		}
		else
			balance = balance - withdrawAmount;
	} // end withdraw

	public void deposit(double depositAmount){
		balance = balance + depositAmount;
	} // end deposit

	public String getType(){
		return type;
	}
	public double getBalance(){
		return balance;
	}

	public double getInterestRate(){
		return interestRate;
	}

	public void showBalance(){
		System.out.println(balance);
	}
} // end class def
