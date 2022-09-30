// user.h
// This is the User object, which has its own menu, checking account, savings account, and login credentials

#ifndef USER_H_EXISTS
#define USER_H_EXISTS

#include <string>
#include "account.h"
     
class User{
    
    private:
        std::string* accountNumber;
        std::string* pin;
        Account* checkingAccount;
        Account* savingsAccount;
	
    public:
    
        User(std::string id,std::string pi);
    
        User(std::string properties);
    
        ~User();

        std::string getId();

        std::string getPin();
    
        Account getCheckingAccount();
    
        Account getSavingsAccount();

        std::string getProps();

        void displayActions();
               
}; // end class def
#endif
