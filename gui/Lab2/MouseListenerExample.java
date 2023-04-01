import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


// new class that implements MouseListener interface ;

/**
 * MouseListener
 */
public class MouseListenerExample implements MouseListener{

    private static final int Label_CENTER = 0;
    //create two labels
    Label lbl1,lbl2;
    Frame fr; //create a frame

    String s; //create a sting s

    MouseListenerExample(){
        fr =  new Frame("Java Mouse Listener Example");
        lbl1 =  new Label("Demo for the mouse event ",Label_CENTER);
        lbl2 =  new Label(); //set the layout of fame as flow layout

        fr.setLayout(new FlowLayout()); 
        fr.add(lbl1); //add label 1 to frame
        fr.add(lbl2);  //add label 2 to frame

        fr.addMouseListener(this);

        fr.setSize(350,350);
        fr.setVisible(true);

    }
    
    public void mouseClicked(MouseEvent ev)
    {
         s+=" then,the  mouse button is clicked";
         lbl2.setText(s);
         fr.setVisible(true);
    }

    public void mouseEntered(MouseEvent ev){
     lbl2.setText("mouse has left area");
         fr.setVisible(true);
    }

    public void mouseExited(MouseEvent ev)
    {
         
         lbl2.setText("mouse has left area");
         fr.setVisible(true);
    }
    public void mousePressed(MouseEvent ev)
    {
         
        lbl2.setText("mouse button is  being pressed");
        fr.setVisible(true);
   }
   public void mouseReleased(MouseEvent ev)
    {
         
        lbl2.setText("mouse button is  being released");
        fr.setVisible(true);
   }

   public static void main(String[] args) {
    new MouseListenerExample();
   }
}

