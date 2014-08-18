import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveTest  extends JPanel
{
  private final LinkedList<Rectangle> theRectangles = new LinkedList<Rectangle>();
  
  public MoveTest() { 
    super();
    setSize(new Dimension(400, 400));
    setMinimumSize(new Dimension(400, 400));
    setFocusable(true);
    requestFocusInWindow();
  }
  
  public void paintComponent(Graphics g) {
    Graphics2D theGraphics = (Graphics2D) g;
    
    for(Rectangle theRectangle : theRectangles) { 
      theGraphics.drawRect((int)theRectangle.getX(),(int)theRectangle.getY(), 
                           (int)theRectangle.getWidth(), (int)theRectangle.getHeight());
    }
  }
  
  public void drawRectangle(final Rectangle theRectangle) { 
    this.theRectangles.add(new Rectangle(theRectangle));
    repaint();
  }
  
  
  public static void main(String[] ryan)
  {
    final MoveTest theMover = new MoveTest();
    
    JFrame theFrame = new JFrame("For Noel");
    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theFrame.setSize(500, 500);
    theFrame.add(theMover);
    theFrame.setVisible(true); 
    
    Rectangle cerealBox = new Rectangle(5, 10, 20, 30);
    theMover.drawRectangle(cerealBox);
   
    cerealBox.translate(100, 205);
    
    theMover.drawRectangle(cerealBox);
    
    System.out.println(cerealBox);
  }
}
