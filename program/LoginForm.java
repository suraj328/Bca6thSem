import java.awt.FlowLayout;
import javax.swing.*;
class LoginForm extends JFrame{
	public static void main(String [] args){
		JFrame f1 = new JFrame("form");
		JPanel p1 =new JPanel();
		p1.setLayout(new FlowLayout());
		JLabel l1= new JLabel("example");
		p1.add(l1);
		f1.add(p1);
		f1.setSize(200,300);
		f1.setLocationRelativeTo(null);
		//f1.setDefaultCloseOperation(JFrame.EXIT_CLOSE);
		f1.setVisible(true);
	}
}