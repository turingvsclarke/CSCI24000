// admin.h
// This is the admin class, which will load the user data and have a menu controlling the bank accounts and users

#ifndef ADMIN_H_EXISTS
#define ADMIN_H_EXISTS

#include <string>
#include <vector>
#include "account.h"
#include "user.h"

class Admin{	
    
        private:
            std::string* userId;
            std::string* pin;
            std::vector<User*> userList;

        public:

            Admin(std::string id,std::string passcode);
            ~Admin();

            std::string getId();

            std::string getPin();

            std::vector<User*> getUserList();

            void displayOptions();

            void removeUser();

            void addUser();

            // this function will write the list of users to a file
            void updateUsers();

            // this function will read from the list of users
            void loadUsers();

            void listUsers();

            void applyInterest();
  }; // end class def
#endif

