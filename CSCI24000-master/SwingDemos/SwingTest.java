// SwingTest

// start by importing the swing library

import javax.swing.*;


public class SwingTest{
    public static void main(String args[]){
     
        JFrame frame = new JFrame();     // we could also have SwingTest inherit JFrame
        
        JButton button = new JButton("Click here");  // we create an object to add on to the frame. Of course, all widgets we add are objects themselves
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(button);    // better to declare a Content object, but I can't remember what class it comes from, so this works for only doing one thing to it. It'd be annoying to repeat this five times for every widget addition or color change
        
        frame.setSize(300,300);        // Andy says you can use "pack()", but I've never got it to work
        
        frame.setVisible(true);
    
    
        // let's 



    } // end main


} // end SwingTest