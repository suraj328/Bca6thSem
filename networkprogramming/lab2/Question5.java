import java.net.InetAddress;
//check inetaddress is reachable or not
public class Question5 
{
    public static void main(String[] args) {
        try {
            InetAddress net =  InetAddress.getByName("192.168.56.1");
            if(net.isReachable(100)){
                System.out.println("success");
            }else{
                System.out.println("failed");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
