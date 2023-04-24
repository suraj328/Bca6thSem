import java.net.*;

public class IsRaechableExample {
    /*isReachable() is method which checks wheither domain is reachable or not */
   public static void main(String[] args) {
    try {
        InetAddress adr =  InetAddress.getByName("www.facebook.com");

        boolean status = adr.isReachable(6000);
        if(status){
            System.out.println("Given doamain is reachable status: " + status);
        }else{
            System.out.println("Given doamain is not  reachable status: " + status);
        }
        
    } catch (Exception e) {
        System.out.println("error: "+ e);
    }
   } 
}
