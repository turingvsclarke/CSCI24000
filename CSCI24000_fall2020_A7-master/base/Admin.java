// Admin.java
// This is the admin class, which will load the user data and have a menu controlling the bank accounts and users

import java.util.*;
import java.io.*;

public class Admin{	
	String userId;
	String pin;
	ArrayList<User> userList;
	Scanner input = new Scanner(System.in);
	
	public Admin(String id,String passcode){
		userId=id;
		pin=passcode;
		loadUsers();
	} // end constructor
	
	public static void main(String args[]){
	}

	public String getId(){
		return userId;
	}

	public String getPin(){
		return pin;
	}

	public ArrayList<User> getUserList(){
		return userList;
	}

	public void displayOptions(){
		boolean exit = false;
		while(!(exit)){
			System.out.println("\n(1) Add a user\n(2) Delete a user(account must be empty)\n(3) List all users\n(4) Apply interest to all savings accounts\n(5) Exit");
			System.out.println("Please enter the number of your selection:");
			int select = input.nextInt();
			switch(select) {
				case 1:
					// code to add a user	
					addUser();
					System.out.println("Returning to options...");	
				break;
				case 2:
					// code to delete a user
					removeUser();
					System.out.println("Returning to options...");
				break;
				case 3:
					// code to list all users
					listUsers();
					System.out.println("Returning to options...");
				break;
				case 4:
					applyInterest();
					System.out.println("Returning to options...");
				break;
				case 5:
					exit = true;
					System.out.println("Returning to main login page...");	
				break;
			}
		}
	
	} // end displayOptions

	public void removeUser(){
		listUsers();
		System.out.print("Number of user to remove:");
		int i = input.nextInt()-1;
		if(userList.get(i).getCheckingAccount.getBalance()==0 && userList.get(i).getSavingsAccount.getBalance()==0){
			userList.remove(i);
		}
		else{
			System.out.println("Cannot delete a user with a nonzero balance. Redirecting to main login...");
		}
		updateUsers();
	}

	public void addUser(){
		System.out.print("ID of new user:");
		String id = input.next();
		if(!(id.toUpperCase().equals(id) && id.toLowerCase().equals(id)) || id.equals("00000")){
			System.out.println("Invalid ID");
			return;
		}
		for(int i=0;i<userList.size();i++){
			if(userList.get(i).getId().equals(id)){
				System.out.println("User already exists");
				return;
			}		
		}
		System.out.print("PIN of new user:");
		String pin = input.next();
		User u = new User(id,pin);
		userList.add(u);	
		System.out.println("\nNew user has been added with a starting balance of 0.00. Redirecting to main login...");
		updateUsers();
	}

	// this function will write the list of users to a file
	public void updateUsers(){
		boolean append = false;
		for(int i=0;i<userList.size();i++){
			if(i>0){
				append = true;
			}
			User user = userList.get(i);
			// print the user data string to a file
			Account savings = user.getSavingsAccount();
			String data = userList.get(i).getProps();
			try {
				FileWriter outfile = new FileWriter("users.txt",append);
				PrintWriter output = new PrintWriter(outfile);
				
				output.println(data);

				outfile.close();	
				output.close();
			} catch(IOException e){
				System.out.println("Failed to store user");
			}
			
		}
	}

	// this function will read from the list of users
	public void loadUsers(){	
		userList = new ArrayList<User>();	
		
		// load the users from a users.txt file
		try{
			File theFile = new File("users.txt");
			Scanner fileInput = new Scanner(theFile);
			while(fileInput.hasNext()){
				String line = fileInput.nextLine();
				User user = new User(line);
				userList.add(user);
			}
		
		fileInput.close();
		} catch(IOException e){
			System.out.println("No user list able to to be loaded");
		} // end catch
	}

	public void listUsers(){
		for(int i=0;i<userList.size();i++){
			System.out.println((i+1) + ". " + userList.get(i).getId());
		}
	}

	public void applyInterest(){
		System.out.print("Please provide the number of integer months since last interest application:");
		int months = input.nextInt();
	       	for(int i=0;i<userList.size();i++){
			Account savings = userList.get(i).getSavingsAccount();
			// deposit the interest amount in the user's savings
			savings.deposit(savings.getBalance()*(months*savings.getInterestRate()));
		}
	} // end applyInterest

} // end class def

