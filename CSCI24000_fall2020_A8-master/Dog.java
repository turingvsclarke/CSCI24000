// Dog.java

// A generic dog class

public class Dog extends Pet{
  public Dog(){
    super("Fido");
  }
  public Dog(String name){
      super(name);
  }
  public void feed(){
    System.out.println("The dog has been given a bone");
  }

  public void bathe(){
    System.out.println("The dog has been given a bath");

  }


} // end class
