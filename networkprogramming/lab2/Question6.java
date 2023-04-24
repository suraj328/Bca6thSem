//list all networ interface
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Question6 {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces =  NetworkInterface.getNetworkInterfaces();
        while(interfaces.hasMoreElements())
        {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
    }
}
