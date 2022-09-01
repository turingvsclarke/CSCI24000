// Bank.java

// This is the main function that controls the login menu
import java.util.*;

// For now we just print the login menu. That's it. Later we'll create the objects.

public class Bank {
	public static void main(String args[]){
	
		Admin main = new Admin("00000","12345");	
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		while(!exit){
			exit = true;
			System.out.println("----------Login Menu(enter 'q' twice to exit)-----------");
			System.out.print("User ID:");	
			String userID = input.next();
			System.out.print("PIN:");
			String PIN = input.next();
			// check if the login belongs to the admin
			if(main.getId().equals(userID) && main.getPin().equals(PIN)){
				main.displayOptions();
				exit = false;
			} // end if
			ArrayList<User> users = main.getUserList();

			// check if the login belongs to any of the users	
			for(int i=0;i<users.size();i++){
				User user = users.get(i);
				if(user.getId().equals(userID) && user.getPin().equals(PIN)){
					exit=false;
					user.displayActions();
					
					// update any changes to the user
					main.updateUsers();
				} // end if
			} // end for	
			
			if(exit){
				System.out.println("No known user found. \n\n\n\n\nExiting system...\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nGoodbye! :)");
			}
		} // end while
	} // end main
} // end class def

