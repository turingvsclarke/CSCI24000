// helloSwing.java
// My first Swing program to demonstrate what's going on

// we need the util package as always, but now we also add the swing library and awt since we'll be using ancestors of jFrame all the time
import javax.swing.*;
import java.awt.*;

public class HelloSwing extends JFrame{

        // main method, instantiating our swing class
        public static void main(String args[]){
                // invoke constructor
                new HelloSwing();
        } // end main

        public HelloSwing() {
                // initialize JFrame class using 'super' to invoke parent constructor
                super("James");

                Container ourContainer = this.getContentPane();

                ourContainer.setBackground(Color.red);
                // this.getContentPane();

                // We want to add a graphical interface, this allows us to mess with the graphics
                Graphics graphicalPiece = this.getGraphics();


                // does nothing on iMac
                this.pack();

                // a decent size
                this.setSize(400,800);


                this.setVisible(true);
        } // end constructor


}
