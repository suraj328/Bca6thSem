
/**
 * Inet4Address
 */
import java.net.*;
public class Inet4AddressExample {

    public static void main(String[] args) {
        try {
            // creating instance for local machine to get ip of your local machine
            InetAddress ia =  InetAddress.getLocalHost();
            System.out.println("-------------LocalMachine------------");
            //it creates inetv4address instance to store local host ip it teakes your local machine ip as paramaeter 
            // inet4Adress is used for typcasting get ip into ipv4 address
            Inet4Address localAddress = (Inet4Address) Inet4Address.getByName(ia.getHostAddress());
            //print ipv4 address of your local machine
            System.out.println("local host adress: " + localAddress.getHostAddress());
            //print ipv4 host name of your local machine
            System.out.println("local host name: " + localAddress.getHostName());


            System.out.println("-------------Remote Machine------------");
            //cretaing instance of Internet4address to strore ipv4  address and host name of facebook;
            Inet4Address remoteAddress = (Inet4Address) Inet4Address.getByName("www.google.com");
            //print ipv4 address of any remote machine
            System.out.println("remote uthinkcrazy host adress: " + remoteAddress.getHostAddress());
            //print ipv4 host name of any remote machine
            System.out.println("remote host name: " + remoteAddress.getHostName());

            System.out.println("-------------comparing teo machine------------");
            // comparing ip address of two machine for equality
            boolean isEqual = ia.equals(remoteAddress);
            System.out.println("local host ip and remote ip matching is: "+ isEqual);

        } catch (Exception e) {
            System.out.println("error occured:- "+ e);
        }
    }
    
}