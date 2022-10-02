// Hunger.java
// the Attributes class already has all we need, so we literally just give it a list of values

public class Hunger extends Attribute{

    // assuming Attributes class has the array listed in an array called values(can't remember)
    final static String[] values = {"starving","hangry","lean","content","full","stuffed","nauseous"};

    // Main method just to test this class a bit
    public static void main(String args[]){

      Hunger a = new Hunger();

    } // end main

      // we send the list to the parent constructor, since it already knows how to handle things
      public Hunger(){
        super(values);
      }

} // end Clean
