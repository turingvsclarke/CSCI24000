// LearnSwing.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LearnSwing extends JFrame implements ActionListener{
  JButton button1;
  boolean clicked = false;

  public static void main(String[] args) {
    LearnSwing myLearnSwing = new LearnSwing();
  }

  public LearnSwing(){
    super("This app is sexy");

    Container contentArea = this.getContentPane();

    button1 = new JButton("Click me");

    button1.addActionListener(this);

    contentArea.add(button1);

    JButton button2 = new JButton();

    this.setSize(400,600);
    this.setVisible(true);
  } // end constructor

  public void actionPerformed(ActionEvent e){
    // reset the button back and forth between asking to be clicked and saying its been clicked
    if(clicked){
      button1.setText("Click me");
      clicked = false;
    }
    else if(!clicked){
      button1.setText("I've been clicked");
      clicked = true;
    }

  }


} // end LearnSwing
