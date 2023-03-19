/**
 * LoginFormGui
 */
import java.awt.*;
import javax.swing.*;
public class LoginFormGui extends JFrame 
{
    public void loginFormGui()
    {
        JFrame f1 = new JFrame();
        f1.setSize(600,400);
        f1.setTitle("User Login");
        f1.setResizable(true);
        f1.setVisible(true);
        ImageIcon img1 = new ImageIcon("sample.jpg");
        f1.setIconImage(img1.getImage());
        f1.getContentPane().setBackground(Color.cyan);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
     {
        LoginFormGui login =  new LoginFormGui();
        login.loginFormGui();
    }
}