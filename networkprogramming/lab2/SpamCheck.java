

import java.net.InetAddress;
import java.net.UnknownHostException;
public class SpamCheck {
    public static final String LOOKUP_HOST = "sbl.spamhaus.org";

    public static void main(String[] args) {
        String[] hosts = {"207.34.56.23", "125.12.32.4", "130.130.130.130", "www.facebook.com"};
        for (String host : hosts) {
            if (isSpammer(host)) {
                System.out.println(host + " is a known spammer.");
            } else {
                System.out.println(host + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            byte[] addressBytes = address.getAddress();
            StringBuilder query = new StringBuilder(LOOKUP_HOST);
            for (byte number : addressBytes) {
                int unsignedByte = number < 0 ? number + 256 : number;
                query.insert(0, unsignedByte + ".");
            }
            InetAddress addr = InetAddress.getByName(query.toString());
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}