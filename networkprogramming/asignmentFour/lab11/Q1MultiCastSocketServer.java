package asignmentFour.lab11;

/**
 * Q1MultiCastSocketServer
 */
// import java.net.DatagramPacket;
import java.net.*;

public class Q1MultiCastSocketServer {
public static void main(String[] args) {
    try {
        InetAddress multicastGroup =  InetAddress.getByName("239.0.0.1");
        int port =8888;
        MulticastSocket multicastSocket = new MulticastSocket(port);
        multicastSocket.joinGroup(multicastGroup);
        // create a buffer to store data
        String message = "Hello from the server";
        byte [] buffer = message.getBytes();

        // create datagram packet
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,multicastGroup,port);
        // send the packet
        while (true) {
            multicastSocket.send(packet);
            System.out.println("send multicast message :"+ message );
            Thread.sleep(1000);//wait for 1 second
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}