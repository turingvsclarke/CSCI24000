// User.java
// This is the User object, which has its own menu, checking account, savings account, and login credentials

#include "account.h"
#include "user.h"

#include <sstream>
#include <iostream>
#include <string>
	
	User::User(std::string id,std::string pi){
		User::accountNumber = new std::string(id);
		User::pin = new std::string(pi);
		User::savingsAccount = new Account("savings",0.0,.01);
		User::checkingAccount = new Account("checking",0.0,0);
	}

	User::User(std::string properties){
		std::string props[8];
        // assign all the elements in the string to a property
		for(int i=0;i<8;i++){
            
			int index = properties.find(',');
			if(index<0){
				props[i]=properties;
				break;
			}
			props[i] = properties.substr(0,index);
			properties = properties.substr(index+1);
		}
		User::accountNumber=new std::string(props[0]);
		User::pin = new std::string(props[1]);
		User::checkingAccount = new Account(props[2]+","+props[3]+","+props[4]);
		User::savingsAccount = new Account(props[5]+","+props[6]+","+props[7]);
	}; // end constructor

    User::~User(){
        delete accountNumber;
        delete pin;
        delete savingsAccount;
        delete checkingAccount;
    }

	std::string User::getId(){
		return *accountNumber;
	}

	std::string User::getPin(){
		return *pin;
	}
	Account User::getCheckingAccount(){
		return *checkingAccount;
	}
	Account User::getSavingsAccount(){
		return *savingsAccount;
	}

	std::string User::getProps(){
		return *accountNumber +","+*pin+"," + checkingAccount->getProps()+","+savingsAccount->getProps();
	}

	void User::displayActions(){
        
		bool exit = false;
        
		while(!(exit)){
			std::cout<<std::endl<<"(1) Get checking balance"<<std::endl<<"(2) Deposit into checking"<<std::endl<<"(3) Withdraw from checking"<<std::endl<<"(4) Get savings balance"<<std::endl<<"(5) Deposit into savings"<<std::endl<<"(6) Withdraw from savings"<<std::endl<<"(7) Exit"<<std::endl;
			std::cout<<"Please enter the number of your selection:"<<std::endl;
            
			int select;
            std::cin >> select;
			double deposit;
            double withdraw;
            switch(select) {
				case 1:
					checkingAccount->showBalance();	
				break;
                case 2:
					std::cout<<"Deposit amount:";
                    std::cin >> deposit;
					checkingAccount->deposit(deposit);
					std::cout<<"Successfully deposited. Returning to options..."<<std::endl;
				break;
				case 3:
					std::cout<<"Withdrawal amount:";
                    std::cin >> withdraw;
					checkingAccount->withdraw(withdraw);
					std::cout<<"Returning to options..."<<std::endl;
				break;
				case 4:
					savingsAccount->showBalance();
				break;
				case 5:
					std::cout<<"Deposit amount:";
                    std::cin >> deposit;
					savingsAccount->deposit(deposit);
					std::cout<<"Successfully deposited. Returning to options..."<<std::endl;
				break;
				case 6:
					std::cout<<"Withdrawal amount:";
                    std::cin >> withdraw;
					savingsAccount->withdraw(withdraw);	
					std::cout<<"Returning to options..."<<std::endl;
				break;
				case 7:
					exit = true;
					std::cout<<"Returning to main login page..."<<std::endl;	
				break;
			}
		}
	}

