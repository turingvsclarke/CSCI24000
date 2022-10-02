// Lizard.java

public class Lizard extends Pet{
    int tailLife;

    public Lizard(){
      super("Lizzy");
    }
    public Lizard(String name){
      super(name);
    }

    public void bathe(){

        // when we bathe we'll increase the lizard's cleanliness a few points

        System.out.println("Your lizard has been scrubbed, sir");
    }

    public void feed(){
        // when we feed we'll decrease the lizard's hunger level
        System.out.println("The lizard has been fed its crickets, sir");
    }


} // end Lizard class
