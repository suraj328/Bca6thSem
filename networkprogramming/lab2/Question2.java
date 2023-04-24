//program to find the local ip address of the machine
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Question2 {
    public static void main(String[] args) {
        try {
            InetAddress me = InetAddress.getLocalHost();
            String dottedQuad = me.getHostAddress();
            System.out.println("My address is: "  + dottedQuad);
        } catch (UnknownHostException e) {
            System.out.println(" I am soory  i cant find my own address "+ e);
        }
    }
}
