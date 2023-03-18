import java.net.*;

public class Inet6AddressExample {
    public static void main(String[] args) {
        try {
        // create an instance for Inet6Address
        Inet6Address i6  = (Inet6Address) Inet6Address.getByName("fe80::2b1b:7fb6:d026:9996%13");
        System.out.println("address is: "+i6.getHostAddress());
        System.out.println("host name is: "+i6.getHostName());

        // remote
        Inet6Address remotei6  = (Inet6Address) Inet6Address.getByName("www.google.com");
        System.out.println("address is: "+remotei6 .getHostAddress());
        System.out.println("host name is: "+remotei6 .getHostName());

        } catch (Exception e) {
            System.out.println("error: "+e);
        }
    }
}
