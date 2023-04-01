import java.awt.*;
import java.awt.event.*;
public class MouseAdapterExample extends MouseAdapter
{
    Frame f;
    // class constructor
    MouseAdapterExample()
    {
        // creating the frame with title
        f =  new Frame("Mouse Adapter");
        //adding Mouse Listener to the Frame
        f.addMouseListener(this);
        //setting the size layout  and visibilty of the frame;
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }

    //override the mouseClicked() method of the MouseAdapter class
    public void mouseClicked(MouseEvent e)
    {
        //credating the graphics object and fetching them from the frame object using getGraphics() method
        Graphics g = f.getGraphics();
        //setting the color of graphics object
        g.setColor(Color.BLUE);
        //setting the shape of graphics object
        g.fillOval(e.getX(), e.getY(), 30, 30);
    }
    public static void main(String[] args) 
    {
        new MouseAdapterExample();
    }
}
