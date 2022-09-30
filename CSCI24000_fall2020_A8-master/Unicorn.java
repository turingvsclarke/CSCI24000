// Unicorn.java

// A generic unicorn CLASS

public class Unicorn extends Pet{
  public Unicorn(){
    super("Magic Uke");
  }
  public Unicorn(String name){
    super(name);
  }

  public void feed(){
    System.out.println("The unicorn has been fed some magic oats.");
  }

  public void bathe(){
    System.out.println("The unicorn has been washed with five magic rainbows");

  }


} // end class
