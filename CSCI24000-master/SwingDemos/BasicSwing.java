// LearnSwing.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BasicSwing extends JFrame implements ActionListener{
  JButton button1;
  boolean clicked = false;
  Container contentArea;

  public static void main(String[] args) {
    BasicSwing myLearnSwing = new BasicSwing();
  }
  public BasicSwing(){
    this("This app is sexy");
  }

  public BasicSwing(String title){
    super(title);

    contentArea = this.getContentPane();

    String imageFile = "chromaticGraphIcon.png";
    ImageIcon graphIcon = new ImageIcon(imageFile);
    this.setIconImage(graphIcon.getImage());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(1200,600);
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
