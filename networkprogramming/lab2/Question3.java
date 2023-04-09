//program to verify to domain
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Question3 {
    public static void main(String[] args) {
        try {
            InetAddress ibiblio = InetAddress.getByName("www.facebook.com");
            InetAddress helios =  InetAddress.getByName("www.fb.com");
            if(ibiblio.equals(helios)){
                System.out.println("both domain are matched");
            }else{
                System.out.println("domain not matched");
            }
        } catch (UnknownHostException e) {
            System.out.println("host look up failed: " + e);
        }
    }
}
