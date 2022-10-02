// Duck.java

// A generic duck class

public class Duck extends Pet{
  public Duck(){
    super("Millard");
  }
  public Duck(String name){
    super(name);
  }
  public void feed(){
    System.out.println("The duck has been given feed");
  }

  public void bathe(){
    System.out.println("The duck has been bathed");

  }


} // end class
