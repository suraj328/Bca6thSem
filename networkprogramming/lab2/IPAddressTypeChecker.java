import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressTypeChecker {
    public static void main(String[] args) {
        try {
            // String ipAddress = "192.168.0.1"; // Replace with the IP address you want to check
            String ipAddress = "fe80::"; // Replace with the IP address you want to check

            InetAddress address = InetAddress.getByName(ipAddress);
            System.out.println(address.getHostAddress());

            if (address instanceof java.net.Inet4Address) {
                System.out.println(ipAddress + " is an IPv4 address.");
            } else if (address instanceof java.net.Inet6Address) {
                System.out.println(ipAddress + " is an IPv6 address.");
            } else {
                System.out.println(ipAddress + " is not a valid IP address.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Invalid IP address: " + e.getMessage());
        }
    }
}
