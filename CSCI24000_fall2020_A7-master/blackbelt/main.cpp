// Bank.java

// This is the main function that controls the login menu
#include<string>
#include "user.h"
#include "account.h"
#include "admin.h"
#include<iostream>

// For now we just print the login menu. That's it. Later we'll create the objects.

int main(){
	
		Admin* main = new Admin("00000","12345");	
		bool exit = false;
		while(!exit){
			exit = true;
			std::cout<<"----------Login Menu(enter 'q' twice to exit)-----------"<<std::endl;
			std::cout<<"User ID:";	
            std::string userID;
            std::cin >> userID;
			std::cout<<"PIN:";
            std::string PIN;
            std::cin >> PIN;
			// check if the login belongs to the admin
			if(main->getId()==userID && main->getPin()==PIN){
				main->displayOptions();
				exit = false;
			} // end if
			std::vector<User*> users = main->getUserList();

			// check if the login belongs to any of the users	
			for(int i=0;i<users.size();i++){
				User* user = users[i];
				if(user->getId()==userID && user->getPin()==PIN){
					exit=false;
					user->displayActions();
					
					// update any changes to the user
					main->updateUsers();
				} // end if
			} // end for	
			
			if(exit){
				std::cout<<"No known user found. "<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<"Exiting system..."<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<std::endl<<"Goodbye! :)"<<std::endl;
			}
		} // end while
	} // end main

