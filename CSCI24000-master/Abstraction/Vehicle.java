// Vehicle.java
import java.util.*;
public class Vehicle{
  String type;

  public static void main(String args[]){
    Vehicle dumpTruck = new Vehicle("Dump truck"); // testing single param constructor
    Vehicle anonymous = new Vehicle(); // testing null param constructor

  }  // end main

  public Vehicle(){
    this.type="boring vehicle";
    this.getType();
    System.out.println("We're in the vehicle class\n\n----------------\n\n");
  } // end null constructor

  public Vehicle(String type){
    this.steerLeft();
    this.type = type;
    this.getType();
    System.out.println("We're in the vehicle class\n\n----------------\n\n");

  } // end single parameter constructor

  public void getType(){
    System.out.println("Type of ride: " + this.type);  // print out the type attribute for the car in a nice way
  } // end getType

  public void steerLeft(){

    System.out.println("Look ma! No hands!(vehicle method)");
  } // end steerLeft

  public void steerRight(){
  } // end steerRight

  public void speedUp(){} // end speedUp

  public void slowDown(){} // end slowDown

}  // end class definition
