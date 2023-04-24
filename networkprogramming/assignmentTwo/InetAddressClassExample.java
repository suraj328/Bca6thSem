

import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
public class InetAddressClassExample {

    public static void main(String[] args) {
        try {
            /*This isfor inet address
             * summary
             * import java.net.* package for inetaddress
             * for using inetaddress first object should created using InetAddress keyword as:-
             * InetAddress objectName = InetAddress.getLocalHost(); only for your computer
             * InetAddress objectName = InetAddress.getByName("Domain name");for other like remote pc
             */

            System.out.println("--------------Local Machine-----------------------");
            //provide a localhost name  and ipadresss of your local computer
            InetAddress localhost =  InetAddress.getLocalHost();
            // provide you a host name of your local machine
            System.out.println("Your Computer LocalHost is:- "+localhost.getHostName());
            // provide you a ip addres of your local machine
            System.out.println("Your Computer ip is:- "+localhost.getHostAddress());

            System.out.println("--------------Remote Machine-----------------------");
            //provide a ip address and hostname of remote computer or domain name
            InetAddress facebook = InetAddress.getByName("www.facebook.com");
            // provide you a host name of remote machine , it will provide facebook host name
            System.out.println("facebook host name is:- "+facebook.getHostName());
            // provide you a ip address of remote machine , it will provide facebook ip address
            System.out.println("facebook ip address is:- "+facebook.getHostAddress());
            
            System.out.println("--------------Network Interface-----------------------");
            /*
             * This is for network interface
             * networkinterface  information cannot store directly in array network interface have contain data in like collection of objects
             * so for that we have to use Enumeration here enumeration is library which store multiple collection of objects
             * enumeration takes two method one is hasMoreElement() and nextElemet();
             */
            Enumeration<NetworkInterface> interfacesCard = NetworkInterface.getNetworkInterfaces();
            //hasMoreElements() is method of enumaration it returns true  if have many object false no object present
            while(interfacesCard.hasMoreElements()){
            //nextElments() is method of enumaration used to acces object inside enumeration one by one
                NetworkInterface ni =  interfacesCard.nextElement();
                // provide name of connected interface like wlan1  etho
                System.out.println("interface name: " +ni.getName());
                //provide the name of interface adpater or card like intelr 0152 , Microsoft Wi-Fi Direct
                System.out.println("Display name: "+ni.getDisplayName());
                System.out.println("is running: "+ni.isUp());
                System.out.println("is vrtual: "+ni.isVirtual());
                System.out.println("is loopback: "+ni.isLoopback());
                //provide hardware address
                System.out.println("hardware access: "+Arrays.toString(ni.getHardwareAddress()));
                List<InterfaceAddress> address = ni.getInterfaceAddresses();
                for (InterfaceAddress ia : address) {
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
            System.out.println("error occured :- " +e);
        }
    }
}