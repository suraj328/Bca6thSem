package UDP;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClient {
    public static void main(String[] args) {
        try (DatagramChannel channel = DatagramChannel.open()) {
            String message = "Hello, UDP Server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

            // Specify the server's address and port
            InetSocketAddress serverAddress = new InetSocketAddress("localhost", 12345);

            // Send the data to the server
            channel.send(buffer, serverAddress);

            System.out.println("Message sent: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}