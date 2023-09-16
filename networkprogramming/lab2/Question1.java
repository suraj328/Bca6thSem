import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Question1
 */
public class Question1 {

    public static void main(String[] args)  throws UnknownHostException{
        InetAddress ia = InetAddress.getByName("208.201.239.186");
        System.out.println(ia.getAddress());
        System.out.println(ia.getCanonicalHostName());
    }
}