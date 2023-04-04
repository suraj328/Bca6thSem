import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Key Event Handling 
 *It occurs when a key is pressed on the keyboard.Any  component  can generate these
    events, and a class must implement keyListener to support them
    Following are the key events 
    1.KEY_PRESSED
    2.KEy_RELEASED
 */

/*
 * wap for the following
 * 1.If a user pressed a key "d" , "add "the input taken
 * esle if user pressed a key "g" , "subtract" th input taken
 * synatx
 * 1.object addkeyListener(this)
 * 2.Action performed
 *  2.1 Public void keyPressed(keyEvent e){}
 *  2.2public void KeyReleased(KeyEVent e){}
 *  2.3 public void keyTyped()
 * 
 * e.getkeyChar()=='d'
 */

public class KeyEventHandling extends JFrame implements KeyListener {
    JTextField txt1, txt2, txt3;
    JLabel lbl1, lbl2, lbl3;

    public void guiProgram() {
        this.setSize(600, 600);
        this.setTitle("Key Event Handling");
        this.setResizable(true);
        this.setVisible(true);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        lbl1 = new JLabel();
        lbl1.setText("1st value");
        lbl1.setBounds(90, 100, 150, 30);
        this.add(lbl1);

        lbl2 = new JLabel();
        lbl2.setText("2nd value");
        lbl2.setBounds(90, 125, 150, 30);
        this.add(lbl2);

        txt1 = new JTextField();
        txt1.setText("");
        txt1.setBackground(Color.ORANGE);
        txt1.setBounds(150, 100, 120, 20);
        this.add(txt1);

        txt2 = new JTextField();
        txt2.setText("");
        txt2.setBackground(Color.ORANGE);
        txt2.setBounds(150, 125, 120, 20);
        this.add(txt2);

        lbl3 = new JLabel();
        lbl3.setText("Result");
        lbl3.setBounds(90, 145, 150, 30);
        this.add(lbl3);

        txt3 = new JTextField();
        txt3.setText("");
        txt3.setBounds(90, 200, 100, 30);
        this.add(txt3);

        txt3.addKeyListener(this);

    }

    public void keyPressed(KeyEvent e) {
        // lbl3.setText("Key Pressed");
    }

    public void keyReleased(KeyEvent e) {
        // lbl3.setText("Key Release");

    }

    public void keyTyped (KeyEvent e) {
            // lbl3.setText("Key Typede");
        // if(txt1.getText().trim() == null && txt2.getText().trim() == null)
        // {
            int num1 =  Integer.parseInt(txt1.getText()) ;
           int num2 =  Integer.parseInt(txt2.getText()) ;
             if(e.getKeyChar() == 'd')
             {
                lbl3.setText(String.valueOf(num1+num2));
                txt3.setText("");
             }else if(e.getKeyChar() == 'g')
             {
                lbl3.setText(String.valueOf(num1-num2));
                txt3.setText("");
             }else{
                txt3.setText("");
             }
        // }else{
        //     // JOptionPane.showMessageDialog(this,"First input a Value");  
        // }
           

        }

    public static void main(String[] args) {
        KeyEventHandling k1 = new KeyEventHandling();
        k1.guiProgram();
    }

}