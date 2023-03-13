import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s =  new Socket("localhost",6666);
            DataOutputStream dout =  new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello world1");
            dout.flush();
            dout.close();
            s.close();           
        } catch (Exception e) {
            System.out.println("error:"+e);
        }
    }
}
