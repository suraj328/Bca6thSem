import java.net.*;
import java.util.*;
public class NetworkInterfaceExample {
    public static void main(String[] args) {
        try {
            Enumeration <NetworkInterface> card = NetworkInterface.getNetworkInterfaces();

            while (card.hasMoreElements()) {
               NetworkInterface cardReader = card.nextElement();
               System.out.println("name of your card conection: "+cardReader.getName());
               System.out.println("name of your card hardware: "+cardReader.getDisplayName());
               System.out.println("isUp() running or not ?: "+cardReader.isUp());
               System.out.println("is aloop back imterface: "+cardReader.isLoopback());
               System.out.println("Hardware address: " + cardReader.getHardwareAddress());
               System.out.println("MTU: " + cardReader.getMTU());
                System.out.println("-----------address---------------");
               List <InterfaceAddress> cardAddress = cardReader.getInterfaceAddresses();
               for (InterfaceAddress ia : cardAddress) {
                // provide ip addresss 
                System.out.println("ip address: "+ia.getAddress());
                // provide ip host addresss 
                System.out.println("ip host address: "+ia.getAddress().getHostAddress());
                //subnet mask
                System.out.println("subnet mask: "+ia.getNetworkPrefixLength());
                //provide broadcastId
                System.out.println("broadcast adress: "+ia.getBroadcast());
            }
            }
        } catch (Exception e) {
           System.out.println("error: "+e);
        }
    }
}
