// Attributes class(abstract)

// may eventually switch to using arrayList
// import java.

public abstract class Attribute{

    private String[] values;
    // String currentAttribute;
    private int attributeIndex;

    public Attribute(String[] attributeList){

        this.values = attributeList;
        this.attributeIndex=0;

    }    // end array-valued constructor

    public String getAttribute(){
        return this.values[attributeIndex];
    }

    // Increases the pointer to the attribute if there is a next attribute
    public void increaseAttribute(){
        if(this.attributeIndex==this.values.length-1){
            System.out.println("The maximal value of the attribute has been reached");
        }
        else{
            this.attributeIndex+=1;
        }
    }   // end increaseAttribute

    // Decreases the pointer to the attribute if there is a lesser one
    public void decreaseAttribute(){
        if(this.attributeIndex==0){
            System.out.println("The minimal value of the attribute has been reached");
        }
        else{
            this.attributeIndex-=1;
        }

    }   // end decreaseAttribute

   /*** Test methods: Inititate an Attribute object without being abstract
   public static void main(String args[]){
     String[] values = {"happy","sad"};
     Attribute a = new Attribute(values);
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

   } // end main

   /***Print every attribute in the list
    public void printAttributeList(){

      for(int i=0;i<this.values.length;i++){
        System.out.println(this.values[i]);
      }

    }
    /*** null constructor(never used since Attribute is abstract)
    public Attribute(){

        String[] values = {""};
        this.values = values;
        this.setAttribute(0);

    }    // end null-valued constructor

    /*** Get an attribute by the index.
    public String getAttribute(int newIndex){
      try{
        return this.values(newIndex);
      } catch(Exception e){
        return null;
      }
    }
    /*** Set the attribute to a given index
    public void setAttribute(int newIndex){

      // allow the attribute index to be changed only if the index passed is valid
      try{
        currentAttribute = this.getAttribute(newIndex);

      } catch(Exception e){
        System.out.println("The index given does not match a valid attribute.");
      }

    }  // end setAttribute
    ***/

} // end Attribute
