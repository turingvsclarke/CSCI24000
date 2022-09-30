Bank On It Algorithm
Ryan Eades

Since the only difference between a checking account and a savings account(besides governmental regulation) is that a checking account has no interest. In other words, we can make both instances of an Account class which has type, interest, and balance attributes.

Account: This class handles all bank accounts. Each of them have balance, type(savings/checking), and interest attributes. They will have getters, including one that returns a string in the form 'type,balance,interest' to be used for file input and output and one that prints the balance. The class has deposit and withdrawal methods. Both prompt the user for an amount and either add or subtract to the balance, with the withdraw method never taking the account below zero, and letting the user know if the balance is too low for the desired withdrawal.

User:Each user has an id and a pin. These are stored as strings, that way 0100 is a different id then 00100. The user also has two Account objects, called checking and savings. The user has two constructors, one that is just passed user and id, which initializes accounts with no balance. The other constructor is passed a string of format 'id,pin,bankstring,bankstring', where bank string is as described for the Account object. The user has a menu method that loops with a display and a switch statement with options for withdraws, deposits, and checking balance of either account. The user's selection simply prompts the corresponding method being called on whichever of the users account objects, or ending the menu. Finally, the user will have getters, including one which returns the property string described earlier in this description.   

Admin:The admin class has a user id and pin. It also has an arraylist for storing user objects(since we don't know how many users there will be). Because there is only one admin in our case, we consider the bank to be one where there is a teller or associate overseeing a certain section of all the users. The class has a constructor accepting those two parameters. It also has getters for the userlist, the id, and the pin. The following functions are also added:
		displayOptions:Similar to the user, this prints out a vertical list of the administrator function, with a switch statement, whose code blocks call the right methods for the selected option.
	        removeUser:Calls listUsers and asks for the ranking of the user to remove. Removes that user from the list provided both its accounts are empty. Calls updateUsers.
		addUser:Prompts the user for an id and pin. Checks the id against the admin and other users. Makes sure it contains no letters. Adds to the array a new user with empty balances, then calls the updateUser class.
		updateUsers:This file writes the user list to a users.txt file. It does so with append turned off.
		loadUses:Tries to load all users from a file whose lines are user strings with properties described above. 
		listUsers:Prints out an ordered vertical list of all user ids.
		applyInterest:Prompts the user for the integer number of months of interest accumulation. For each user in the list it deposits interest*principal*time into their savings accounts. 
			
Main: The main class handles the main login menu. It creates an instance of admin with id 00000 and pin 12345. It then prompts the user for an id and pin in a while loop, taking them in as strings for the reasons mentioned above. It compares this to the admin and all of the admin's users. The while loop for the menu terminates only if the login is invalid. Otherwise, the user or admin menu methods are called. It continues to loop, so we prompt the user to enter q twice(clearly an invalid user) to terminate.


Blackbelt: Made in C++. No added functionality but some data structures such as an Array List, etc. added to tailor to the language.

