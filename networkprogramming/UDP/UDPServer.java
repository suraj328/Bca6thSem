package networkprogramming.UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        // Create a socket to listen for incoming UDP packets
        DatagramSocket socket = new DatagramSocket(9999);

        // Create a buffer to store the incoming packet data
        byte[] buffer = new byte[1024];

        // Listen for incoming packets
        while (true) {
            // Receive a packet
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Get the sender's address and port
            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            // Get the message from the packet
            String message = new String(packet.getData(), 0, packet.getLength());

            // Echo the message back to the sender
            DatagramPacket reply = new DatagramPacket(message.getBytes(), message.length(), address, port);
            socket.send(reply);
        }
    }
}
