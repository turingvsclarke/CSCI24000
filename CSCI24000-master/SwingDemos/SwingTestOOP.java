// java SwingTestOOP

// rebuilding the swingTest in a better way

// start by importing the swing library

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// our SwingTest IS-A JFrame and also IS-A ActionListener
public class SwingTestOOP extends JFrame implements ActionListener{

    // declaring the button out of instantiation so that actionPerformed can use import junit.framework.TestCase;
    JButton button;
    Choice selector;

    public static void main(String args[]){


        SwingTestOOP frame = new SwingTestOOP();

      }    // end main

        public SwingTestOOP(){

            Container container = this.getContentPane();  // get the content pane for future use of adding/modifying to it

            button = new JButton("Click here");  // we create an object to add on to the frame. Of course, all widgets we add are objects themselves

            String[] options = new String[5];
            selector = new Choice();

            options[0] = "Hunger";
            options[1] = "Cleanliness";
            options[2] = "Happiness";
            options[3] = "Tiredness";
            options[4] = "Bathroom Urge";

            for(int i=0;i<5;i++){
              selector.insert(options[i],i);

            }

            // we add our frame to the actionListeners waiting to hear that that button is up to stuff. Because the frame is an ActionListener, it automatically fires actionPerformed when an action occurs.
            button.addActionListener(this);

            // this will put the button in the south part of the container
            container.add(BorderLayout.SOUTH,button);

            container.add(BorderLayout.CENTER,selector);

            // Once everything is built we make it visible and pretty
            this.setUpFrame();

          }   // end SwingTestOOP

        // let's create some methods that actually do things with this stuff
        public void actionPerformed(ActionEvent e){               // the ActionListener interface has an actionPerformed method that we can modify to say what it should do
            String currentAttribute = selector.getSelectedItem();
            button.setText(currentAttribute);
        }

        public void setUpFrame(){
          this.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
          this.setSize(300,300);        // Andy says you can use "pack()", but I've never got it to work
          this.setVisible(true);
        }

} // end SwingTest
