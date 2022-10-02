// Happy.java
// the Attributes class already has all we need, so we literally just give it a list of values

public class Happy extends Attribute{

    // This list will never be altered
    final static String[] values = {"depressed","gloomy","melancholy","unhappy","content","pleased","happy","gleeful","jubilant"};

    // Main method just to test this class a bit
    public static void main(String args[]){

      Happy a = new Happy();

      /*** Tester code
      System.out.println(a.getAttribute());
      int x = 0;

      for(;x<10;x++){
        a.increaseAttribute();
        System.out.println(a.getAttribute());
      }

      for(;x>0;x--){
        a.decreaseAttribute();
        System.out.println(a.getAttribute());
      }
      ***/

    } // end main

      // we send the list to the parent constructor, since it already knows how to handle things
      public Happy(){
        super(values);
      }

} // end Attribute
