import java.net.InetAddress;
//check ipv4 or ipv6
import java.net.UnknownHostException;

public class Question4 {
    public static void main(String[] args) {
        try {
            InetAddress ia =  InetAddress.getByName("FF00::");
            byte[] address = ia.getAddress();
            if(address.length ==4)
            {
                System.out.println("Ipv4");
            }
            else if(address.length ==16)
            {
                System.out.println("Ipv6");
            }
        } catch (UnknownHostException e) {
            System.out.println("unablem to dtermine ip address" + e );
        }
    }
}
