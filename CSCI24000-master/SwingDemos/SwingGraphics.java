// SwingGraphics.java

import java.awt.*;
import javax.swing.*;

public class SwingGraphics extends SwingTestOOP{

    public static void main(String args[]){
        // create a new object and test its graphics
        new SwingGraphics();

    } // end main

    public SwingGraphics(){

      Container container = this.getContentPane();

      // we're going to add on a panel that hopefully allows for graphics
      JPanel graphicsPanel = new JPanel();

      PaintablePanel panel = new PaintablePanel();

      // draw a line on the graphics content
      this.add(BorderLayout.CENTER, panel);

      Graphics graphics2 = graphicsPanel.getGraphics();

      panel.setBackground(Color.red);

      //********************************************* NEED TO FIGURE OUT HOW TO GET COORDINATES **************************************************
      int x1 = (int) Math.random()*((int) this.getWidth());
      int x2 = (int) Math.random()*((int) this.getWidth());

      System.out.println(graphicsPanel.getWidth());
      System.out.println(graphicsPanel.getHeight());

      int y1 = (int) Math.random()*this.getHeight();
      int y2 = (int) Math.random()*this.getHeight();

      graphics2.drawLine(5,5,150,150);

      graphics2.fillOval(20,50,100,100);

    }
    // end SwingGraphics

    class PaintablePanel extends JPanel{
      public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);
      }

    }

} // end SwingGraphics class
