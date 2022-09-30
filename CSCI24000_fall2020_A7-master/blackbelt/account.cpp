// Account.java
// This is the Account class. Each account has type, balance, interest rate and withdraw, deposit, showBalance methods

#include "account.h"
#include <string>
#include <iostream>
#include <sstream>
    
Account::Account(std::string x,double y,double z){
		Account::type = new std::string(x);
		Account::balance = new double(y);
		Account::interestRate = new double(z);
	} // end constructor

	Account::Account(std::string properties){
		std::string props[3];	
		for(int i=0;i<3;i++){
			int index = properties.find(',');
			if(index<0){
				props[i]=properties;
				break;
			}
			props[i] = properties.substr(0,index);
			properties = properties.substr(index+1);
		}
		Account::type = new std::string(props[0]);
        double b;
        std::stringstream balance(props[1]);
        balance>>b;
		Account::balance = new double(b);
        double i;
        std::stringstream interest(props[2]);
        interest>>i;
		Account::interestRate = new double(i);

	}; // end constructor

    Account::~Account(){
        delete type;
        delete balance;
        delete interestRate;
    }

	std::string Account::getProps(){
        std::stringstream ss;
        ss << *type<<","<<*balance<<","<<*interestRate;
		return ss.str();
	}

	void Account::withdraw(double withdrawAmount){
		if(withdrawAmount>*balance){
			std::cout<<"Insufficient funds"<<std::endl;
		}
		else
			balance = new double(*balance - withdrawAmount);
	} // end withdraw

	void Account::deposit(double depositAmount){
		balance = new double(*balance + depositAmount);
	} // end deposit

	std::string Account::getType(){
		return *type;
	}
	double Account::getBalance(){
		return *balance;
	}

	double Account::getInterestRate(){
		return *interestRate;
	}

	void Account::showBalance(){
		std::cout<<*balance<<std::endl;
	}

