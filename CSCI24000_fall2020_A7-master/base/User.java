// User.java
// This is the User object, which has its own menu, checking account, savings account, and login credentials

import java.util.*;

public class User{
	Scanner input = new Scanner(System.in);
	String accountNumber;
	String pin;
	Account checkingAccount;
	Account savingsAccount;
	
	public User(String id,String pi){
		accountNumber = id;
		pin = pi;
		savingsAccount = new Account("savings",0.0,.01);
		checkingAccount = new Account("checking",0.0,0);
	}

	public User(String properties){
		String[] props = new String[8];	
		for(int i=0;i<8;i++){
			int index = properties.indexOf(',');
			if(index<0){
				props[i]=properties;
				break;
			}
			props[i] = properties.substring(0,index);
			properties = properties.substring(index+1);
		}
		accountNumber = props[0];
		pin = props[1];
		checkingAccount = new Account(props[2]+","+props[3]+","+props[4]);
		savingsAccount = new Account(props[5]+","+props[6]+","+props[7]);
	}; // end constructor

	public static void main(String args[]){
	} // end main

	public String getId(){
		return accountNumber;
	}

	public String getPin(){
		return pin;
	}
	public Account getCheckingAccount(){
		return checkingAccount;
	}
	public Account getSavingsAccount(){
		return savingsAccount;
	}

	public String getProps(){
		return accountNumber +","+pin+","+checkingAccount.getProps()+","+savingsAccount.getProps();
	}

	public void displayActions(){
		boolean exit = false;
		while(!(exit)){
			System.out.println("\n(1) Get checking balance\n(2) Deposit into checking\n(3) Withdraw from checking\n(4) Get savings balance\n(5) Deposit into savings\n(6) Withdraw from savings\n(7) Exit");
			System.out.println("Please enter the number of your selection:");
			int select = input.nextInt();
			switch(select) {
				case 1:
					checkingAccount.showBalance();	
				break;
				case 2:
					System.out.print("Deposit amount:");
					double deposit = input.nextDouble();
					checkingAccount.deposit(deposit);
					System.out.println("Successfully deposited. Returning to options...");
				break;
				case 3:
					System.out.print("Withdrawal amount:");
					double withdraw = input.nextDouble();
					checkingAccount.withdraw(withdraw);
					System.out.println("Returning to options...");
				break;
				case 4:
					savingsAccount.showBalance();
				break;
				case 5:
					System.out.print("Deposit amount:");
					deposit = input.nextDouble();
					savingsAccount.deposit(deposit);
					System.out.println("Successfully deposited. Returning to options...");
				break;
				case 6:
					System.out.print("Withdrawal amount:");
					withdraw = input.nextDouble();
					savingsAccount.withdraw(withdraw);	
					System.out.println("Returning to options...");
				break;
				case 7:
					exit = true;
					System.out.println("Returning to main login page...");	
				break;
			}
		}
	}
} // end class def
