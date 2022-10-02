// PetInterface.java

import java.util.*;
import java.io.*;

// We should probably have Pets handle some more things. For instance, listing the pet's attributes or displaying the subclass of that pet.

// Once the user has selected a pet, they need to be shown some things they can do with this pet. We may want to have the Pet class have a method that outputs an array of all the different things that a pet can do.

// each instance of the interface will have a list of pets to work with. We're going to need to take input from the user and output (a) the list of pet objects (b) the things that the user can do with each pet. Notice that polymorphism allows us to never

// Maybe a Pet static method that takes in the name of a method and executes the method based on that. It would be nice to not have to work with this from the interface class.

// Pets
/***
static Attribute[] getAttributes(){
    return attributes;
}

static String[] getActions(){
    String[] actions;
    actions = {"","","","","",""};
    return actions;
}

// We need a way to list the pet actions and attributes
petActions(){
    // different methods they can do
    String[] actions = Pet.getMethods();
    for(int i=0;i<actions.length;i++){
        System.out.println("");
    }
}
***/

public class PetInterface{
    // when we create this interface, we also create an array of Pets
    ArrayList pets = new ArrayList();
    Pet currentPet;
    Scanner input = new Scanner(System.in);
    boolean runGame;

    public static void main(String[] args) {
        PetInterface petGame = new PetInterface();
        petGame.startInterface();
        petGame.endInterface();
    }
    // When we initialize the interface, we'll want to populate the array with all the subclasses of pets we've currently come up with

    public PetInterface(){
        this.loadPets();
    }

    // "Main menu method to control everything"
    public void startInterface(){
      runGame = true;
      System.out.println("Welcome!!!\n\n Loading your pets now...\n");

      while(runGame){
        System.out.println("Which pet do you want to play with today?(hit 0 at anytime to leave)");
        this.printPets();
        this.selectPet();

        // System.out.println(currentPet.getClass());

      } // end while

    } // end startInterface

    // petActionMenu: Returns the list of things you can do with each pet
    public void petActionMenu(){
      String[] actions = currentPet.getActions();
      boolean nextAction = true;
      for(int i=0; i<actions.length; i++){
        System.out.println((i+1) + "." + actions[i]);
      }
      while(nextAction){
      try{
	int action = checkInput();
	currentPet.doAction(action-1);
	nextAction=false;
      }catch(Exit e){
      nextAction=false;
	}catch(Exception e){
	System.out.println("Please enter the number of a valid action");
	}
	} // end while

    } // end petActionMenu

    class Exit extends Exception{}

    public int checkInput() throws Exit{

      String inputString = input.nextLine();
      int selection = Integer.parseInt(inputString);

      if(selection==0){
        throw new Exit();
      }
      return selection;
    }

    // Print a list of all the pets for the user to select from
    public void printPets(){
        int i=0;
        for(; i<pets.size(); i++){
        // output each pet in the array(
            currentPet = (Pet) pets.get(i);
            // grab the pets class, which will be of format "class Classname"). Docs tell us that getClass returns something weird, but forcing a concatenation gives us a string
            String type = currentPet.getName() + "("+ currentPet.getClass().getCanonicalName() + ")";

            // print a numbered list of the first five characters so that we only have " Classname"
            System.out.println((i+1) + ". " + type);

        // get its class type and list that class type
        }
        System.out.println((i+1) + ". " + "Add new pet");
    }

    public void selectPet(){
        String inputString = "";
        int petChoice;
          try{
              // get a number from the user(first place we could have an error)
               petChoice = checkInput();
               // Check if the user has opted to add a pet.
               if(petChoice==pets.size()+1){
                 this.addPet();
               }
               else{
                 // This part will fail if i is an invalid number for a pet
                 currentPet = (Pet)pets.get(petChoice-1);
		 this.petActionMenu();
               }
          }catch(Exit e){
              runGame = false;
          }catch(Exception e){
              // do nothing and tell the user they failed
              System.out.println("That's not a valid pet.");
          }

    } // end selectPet

    public void addPet(){
      String[] petSpecies = {"Dog","Cat","Horsey","Lizard","Unicorn"};
      System.out.println("Please select the type you want your new pet to be :)");
      for(int i = 0;i<petSpecies.length;i++){
        System.out.println((i+1) + ". " + petSpecies[i]);
      }

      try{
          int i = checkInput();
          String petType = petSpecies[i-1];
          System.out.println("You said: " + petType);
          System.out.println("Enter a name for your pet:");
          String name = input.nextLine();
          // add the pet
          switch(petType){
            case "Dog":
              this.pets.add(new Dog(name));
              break;
            case "Cat":
              this.pets.add(new Cat(name));
              break;
            case "Horsey":
              this.pets.add(new Horsey(name));
              break;
            case "Lizard":
              this.pets.add(new Lizard(name));
              break;
            case "Unicorn":
              this.pets.add(new Unicorn(name));
              break;
          }
      }catch(Exit e){
        runGame = false;
      }catch(Exception e){
        System.out.println("Enter a valid number");
      }
    } // end addPet

    public void endInterface(){
      System.out.println("Saving your pets...");
      this.savePets();
    }

    // FILE IO
    public void savePets(){
      try{
        FileOutputStream file = new FileOutputStream("Pets.dat");
        ObjectOutputStream objectFile = new ObjectOutputStream(file);

        // Trying to save an array list
        objectFile.writeObject(pets);

      } catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Saving data failed");
      }
    }
    public void loadPets(){
      try{
        FileInputStream file = new FileInputStream("Pets.dat");
        ObjectInputStream objectFile = new ObjectInputStream(file);

        // Trying to read an array list
        pets = (ArrayList) objectFile.readObject();

      /***  while(objectFile.hasNext()){
          pets.add((Pet)objectFile.readObject());
        }
        ***/
      } catch(Exception e){
        System.out.println("Loading data failed");
      }

    }


} // end PetInterface
