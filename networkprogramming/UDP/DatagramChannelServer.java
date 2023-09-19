package UDP;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelServer {
    public static void main(String[] args) {
        try (DatagramChannel channel = DatagramChannel.open()) {
            // Bind the channel to a specific port
            channel.bind(new InetSocketAddress(12345));

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                // Receive data into the buffer
                channel.receive(buffer);
                buffer.flip(); // Prepare for reading

                // Print the received data
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); // Prepare for writing again
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
