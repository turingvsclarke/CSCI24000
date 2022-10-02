// BasicGraphics.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicGraphics extends BasicSwing{
    int x = 5;
    int y=5;
    int width;
    Color color=Color.blue;
    boolean colored=false;
    boolean erased = false;
    GraphicsPanel myPanel;
    JButton b2;

  public static void main(String[] args) {
    new BasicGraphics();
  }

  public BasicGraphics(){
    super("Animation");
    myPanel = new GraphicsPanel();
    Container contentArea = this.getContentPane();
    contentArea.add(BorderLayout.CENTER,myPanel);

    for(int i=0;i<600;i++){
          x++;
          y++;
          myPanel.repaint();
          try{Thread.sleep(50);}
          catch(Exception e){}
      }
  } // end BasicGraphics





  class GraphicsPanel extends JPanel{

    public void paintComponent(Graphics g){
      g.setColor(Color.white);
      g.fillRect(0,0,this.getWidth(),this.getHeight());
      g.setColor(color);
      g.fillOval(0,0,x,y);
    }

  } // end GraphicsPanel class



}  // end BasicSwing class
