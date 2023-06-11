package asignmentFour.lab11;
import java.net.*;
public class Q2MultiCastClientSocket {
    public static void main(String[] args) {
        try {
            // define the multicast group and port
            InetAddress multicastGroup =  InetAddress.getByName("239.0.0.1");
            int port =8888;
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(multicastGroup);
            // create a buffer to store data
            // String message = "Hello from the server";
            byte [] buffer = new byte[1024];
            // create a DatagramPacket for retriving data
            DatagramPacket packet = new  DatagramPacket(buffer,buffer.length);
            while (true) {
                // recive packet
                multicastSocket.receive(packet);
                // extract the recive data
                String recivedData =  new String(packet.getData(),0,packet.getLength());
                // check if the packet is form desired host
                if(packet.getAddress().getHostAddress().equals("192.168.0.100")){
                    System.out.println("Recive data from the desires hsot: "+ recivedData);
                }else{
                    System.out.println("recived data from a differnet host is : "+recivedData );
                }
                // clear the buffer for the next Packet
                packet.setLength(buffer.length);
            }
    
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
