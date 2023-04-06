import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * FlowLayoutExample
 */
// import javax.swing.*;

public class FlowLayoutExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("layout");
        // define new buttons
        JButton jb1 = new JButton("button 1");
        JButton jb2 = new JButton("button 2");
        JButton jb3 = new JButton("button 3");

        // define the pannel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); //setting flowlayout
        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);

        //set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}