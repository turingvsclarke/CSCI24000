// Pet.java
import java.io.*;
public abstract class Pet implements Serializable{
    // every class has a name
    private String name;
    // every class is of a certain species
    private String species;

    public static Happy happy = new Happy();
    public static Hunger hunger = new Hunger();
    public static Clean clean = new Clean();

    public static void main(String args[]){

    }   // end main

    public Pet(){
        this.name = "Anonymous Pet";
        this.species = "Alien";

    } // end null-valued constructor

    public String getName(){
        return this.name;
    }

    public void printSpecies(){
	System.out.println(this.species);
    }

    public Pet(String name){
        this.name = name;
        this.species = species;
    }

    public String[] getActions(){
      String[] actions = {"Find out the species of the pet","Clean the pet","Feed the pet"};
      return actions;
    }

    public void doAction(int i){
	switch(i){
		case 0:
			this.printSpecies();
			break;
		case 1:
			this.bathe();
			break;
		case 2:
			this.feed();
			break;
		} // end switch
    } // end doAction
    

    // every pet needs a way to take a bath, but bathing a horse and bathing a cat are WAAAAY different
    public abstract void bathe();

    // You can't feed crickets to a horse and expect it to live. Lizards will NOT eat rats.
    public abstract void feed();



} // end Pet
