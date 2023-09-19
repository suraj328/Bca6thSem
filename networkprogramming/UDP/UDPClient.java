package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        // Get the server's address and port
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9999;

        // Create a buffer to store the message data
        byte[] buffer = "Hello, world!".getBytes();

        // Create a packet to send to the server
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);

        // Send the packet to the server
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        // Receive the reply from the server
        byte[] replyBuffer = new byte[1024];
        DatagramPacket replyPacket = new DatagramPacket(replyBuffer, replyBuffer.length);
        socket.receive(replyPacket);

        // Get the message from the reply packet
        String message = new String(replyPacket.getData(), 0, replyPacket.getLength());

        // Print the message
        System.out.println(message);
    }
}
