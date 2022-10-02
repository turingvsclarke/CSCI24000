// Cat.java

// A generic horsey class

public class Horsey extends Pet{


  public static void main(String[] args) {
    Horsey h = new Horsey();
  }
  public Horsey(){
    super("Neighdine");
  }
  public Horsey(String name){
    super(name);
  }


  public void feed(){
    System.out.println("The horse has been given some carrots, sugar, and oats");
  }

  public void bathe(){
    System.out.println("The horse has been brushed and its shoes cleaned");

  }


} // end class
