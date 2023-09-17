package lab11;
import java.rmi.*;
public class RmiCLient {
    public static void main(String[] args) {
        try {
            RmiServerIntf obj =  (RmiServerIntf) Naming.lookup("//localhost/RmiServer");
            System.out.println(obj.getMessage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println();
    }
}
