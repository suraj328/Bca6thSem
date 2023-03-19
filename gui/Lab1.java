 //Jframe
//  JPannel
//container\
// component
// event hanlding
//button eveent handling action listener Listener Interface

/**
 * LoginFormGui
 */
import java.awt.*;
import javax.swing.*;
public class Lab1 extends JFrame 
{
    JTextField txt1,txt2;
    JLabel lbl1,lbl2,lbl3;
    JButton btn1,btn2,btn3;

    public void calculation()
    {
	//creating gui for start up
        JFrame f1 = new JFrame();
        f1.setSize(600,400);
        f1.setTitle("calculation");
        f1.setResizable(true);
        f1.setVisible(true);
        ImageIcon img1 = new ImageIcon("sample.jpg");
        f1.setIconImage(img1.getImage());
        f1.getContentPane().setBackground(Color.cyan);
	f1.getContentPane().setLayout(null);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//setting component
	//labeling for  component
	lbl1 =  new JLabel();
	lbl1.setText("num1");
	lbl1.setBounds(90,10,150,30);
	f1.add(lbl1);
	//text field1
	txt1 = new JTextField();
	txt1.setText("");
	txt1.setBounds(90,45,150,30);
	f1.add(txt1);

	lbl2 =  new JLabel();
	lbl2.setText("num2");
	lbl2.setBounds(90,75,150,30);
	f1.add(lbl2);
	//text field1
	txt2 = new JTextField();
	txt2.setText("");
	txt2.setBounds(90,100,150,30);
	f1.add(txt2);

	//creating button component
	btn1 = new JButton();
	btn1.setText("Sum");
	btn1.setBounds(90,135,150,30);
	f1.add(btn1);
	
	btn2 = new JButton();
	btn2.setText("Multiply");
	btn2.setBounds(90,175,150,30);
	f1.add(btn2);
	
	//creating label for result
	lbl3 =  new JLabel();
	lbl3.setText("Result is:");
	lbl3.setBounds(90,205,150,30);
	f1.add(lbl3);
    }

    public static void main(String[] args)
     {
        Lab1 g1 =  new Lab1();
        g1.calculation();
    }
}

