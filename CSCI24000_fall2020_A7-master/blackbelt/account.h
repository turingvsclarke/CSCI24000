// account.h
// This is the Account class header file. Each account has type, balance, interest rate and withdraw, deposit, showBalance methods

#ifndef ACCOUNT_H_EXISTS
#define ACCOUNT_H_EXISTS
    
#include <string>

class Account{
    
    private:
    
        std::string* type;
        double* balance;
        double* interestRate;

	public:
    
        // constructor that takes in the actual parameters
        Account(std::string x,double y,double z);
	
        // constructor by a string of properties
        Account(std::string properties);
    
        ~Account();

	    std::string getProps();
	
        void withdraw(double withdrawAmount);

	    void deposit(double depositAmount);
	
	    std::string getType();
    
        double getBalance();

	    double getInterestRate();

	    void showBalance();
    
}; // end class def
#endif
