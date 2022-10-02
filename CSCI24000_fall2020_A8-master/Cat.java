// Cat.java

// A generic cat class

public class Cat extends Pet{
  public Cat(){
    super("Mittens");
  }
  public Cat(String name){
    super(name);
  }
  public void feed(){
    System.out.println("The cat has been given some milk");
  }

  public void bathe(){
    System.out.println("The cat has licked itself clean");

  }


} // end class
