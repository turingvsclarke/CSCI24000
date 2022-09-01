// Admin.java
// This is the admin class, which will load the user data and have a menu controlling the bank accounts and users
#include "admin.h"
#include "account.h"
#include "user.h"
#include <fstream>
#include <sstream>
#include <iostream>
#include <string>
#include <array>
#include <algorithm>


	Admin::Admin(std::string id,std::string passcode){
		Admin::userId=new std::string(id);
		Admin::pin=new std::string(passcode);
		Admin::loadUsers();
	} // end constructor

    Admin::~Admin(){
        delete userID;
        delete pin
        delete userList;
    }

	std::string Admin::getId(){
		return *userId;
	}

	std::string Admin::getPin(){
		return *pin;
	}

	std::vector<User*> Admin::getUserList(){
		return userList;
	}
 
	void Admin::displayOptions(){
		bool exit = false;
		while(!(exit)){
			std::cout<<std::endl<<"(1) Add a user"<<std::endl<<"(2) Delete a user(account must be empty)"<<std::endl<<"(3) List all users"<<std::endl<<"(4) Apply interest to all savings accounts"<<std::endl<<"(5) Exit"<<std::endl;
			std::cout<<"Please enter the number of your selection:"<<std::endl;
            int select;
            std::cin>>select;
			switch(select) {
				case 1:
					// code to add a user	
					Admin::addUser();
					std::cout<<"Returning to options..."<<std::endl;	
				break;
				case 2:
					// code to delete a user
					Admin::removeUser();
					std::cout<<"Returning to options..."<<std::endl;
				break;
				case 3:
					// code to list all users
					Admin::listUsers();
					std::cout<<"Returning to options..."<<std::endl;
				break;
				case 4:
					Admin::applyInterest();
					std::cout<<"Returning to options..."<<std::endl;
				break;
				case 5:
					exit = true;
					std::cout<<"Returning to main login page...";	
				break;
			}
		}
	
	} // end displayOptions

	void Admin::removeUser(){
		Admin::listUsers();
		std::cout<<"Number of user to remove:";
        int i;
		std::cin>>i;
        i=i-1;
		if(Admin::userList[i]->getCheckingAccount().getBalance()==0 && Admin::userList[i]->getSavingsAccount().getBalance()==0){
            userList.erase(userList.begin()+i);
		}
		else{
			std::cout<<"Cannot delete a user with a nonzero balance. Redirecting to main login..."<<std::endl;
		}
		Admin::updateUsers();
	}

	void Admin::addUser(){
            std::cout<<"ID of new user:";
            std::string id;
            std::string lower=id;
            std::string upper=id;
            transform(upper.begin(),upper.end(),upper.begin(),::toupper);
            transform(lower.begin(),lower.end(),lower.begin(),::tolower);
            if(!(lower==id && upper==id || id=="00000")){
                std::cout<<"Invalid ID"<<std::endl;
                return;
            }
            for(int i=0;i<userList.size();i++){
                if(userList[i]->getId()==id){
                    std::cout<<"User already exists"<<std::endl;
                    return;
                }		
            }
            std::cout<<"PIN of new user:";
            std::string pin;
            std::cin>>pin;
            User* u = new User(id,pin);

            userList.push_back(u);

            std::cout<<std::endl<<"New user has been added with a starting balance of 0.00. Redirecting to main login..."<<std::endl;
            Admin::updateUsers();
	}


	// this function will write the list of users to a file
    void Admin::updateUsers(){
        std::ofstream outFile;
	    std::stringstream s;
        
        bool append = false;
        
        for(int i=0;i<userList.size();i++){
            if(i>0) append=true;
            
                outFile.open("users.txt",append ? std::ofstream::app : std::ofstream::trunc);
               
                if (outFile.is_open()){
                    outFile << userList[i]->getProps()<<std::endl;
                }
         
                else {
                    std::cout << "Unable to access save users" << std::endl;
                } // end else

	            outFile.close();
        }
    }

	// this function will read from the list of users in a file
	void Admin::loadUsers(){	
            std::vector<User*> userList;

            std::ifstream inFile;
            std::string currentLine;
            std::stringstream ss;
            inFile.open("users.txt");

            while(getline(inFile,currentLine)){
                ss.clear();
                ss.str("");
                ss<<currentLine;
                User* u = new User(ss.str());    
                userList.push_back(u);
            } // end while
            inFile.close();
        
            Admin::userList = userList;
	}

	void Admin::listUsers(){
		for(int i=0;i<userList.size();i++){
			std::cout<<i+1<<". "<<userList[i]->getId()<<std::endl;
		}
	}

	void Admin::applyInterest(){
            std::cout<<"Please provide the number of integer months since last interest application:";
            int months;
            std::cin>>months;
                for(int i=0;i<userList.size();i++){
                    Account savings = userList[i]->getSavingsAccount();
                    // deposit the interest amount in the user's savings
                    savings.deposit(savings.getBalance()*(months*savings.getInterestRate()));
            }
	} // end applyInterest

