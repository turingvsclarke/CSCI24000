// Clean.java
// the Attributes class already has all we need, so we literally just give it a list of values

public class Clean extends Attribute{

    // This list will never be altered
    final static String[] values = {"mud","filthy","dirty","musky","clean","perfumed","sparkly","reflective"};

    // Main method just to test this class a bit
    public static void main(String args[]){

      Clean a = new Clean();

    } // end main

      // we send the list to the parent constructor, since it already knows how to handle things
      public Clean(){
        super(values);
      }

} // end Clean
