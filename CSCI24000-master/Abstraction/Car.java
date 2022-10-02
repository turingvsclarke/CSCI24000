// Car.java
// the car IS A vehicle
import java.util.*;


public class Car extends Vehicle{

  // Brand is an enumeration, meaning just a list of different values
  Brand brand;

  public static void main(String args[]){

    // when we call the Car() constructor, the vehicle is created first, so the vehicle THEN car constructor is called
    Car lambo = new Car();
    lambo.brand = Brand.FORD;
    float gas = lambo.getGasAmount();
    System.out.println(gas);
    lambo.openTailgate();
    lambo.steerLeft();

  } // end main function

  public Car(){
    // this invokes the steerLeft method attached to the Vehicle class
    super.steerLeft();
    System.out.println("This is where the Car specific stuff happens\n\n----------------\n\n");

  } // end Car constructor

  public void steerLeft(){

    System.out.println("I'm ridin in my car, what kind of vehicle do you have?(car method)");

  }  // end steerLeft

  public void openTailgate(){

    System.out.println("Heya! Got the tail gate open and I'm ready to drive!");
  } // end openTailgate

  public float getGasAmount(){

    return 10;
  } // end getGasAmount

/***
  public void fillTank(){} // end fillTank

  public void useGas(){

  } // end useGas

  public void steerRight(){}  // end steerRight



  public void closeTailgate(){

    System.out.println("I closed the gate for ya, ma'am. Y'all take care now");

  } // end closeTailgate
***/

} // end Car
