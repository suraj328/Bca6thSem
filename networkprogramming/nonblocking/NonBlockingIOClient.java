package nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingIOClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));

            while (!socketChannel.finishConnect()) {
                // Wait for the connection to be established
            }

            System.out.println("Connected to the server.");

            // Send data to the server
            String message = "Hello, Server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);

            // Read the response from the server
            ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
            int bytesRead = socketChannel.read(responseBuffer);

            if (bytesRead > 0) {
                responseBuffer.flip();
                byte[] responseData = new byte[responseBuffer.remaining()];
                responseBuffer.get(responseData);

                String responseMessage = new String(responseData);
                System.out.println("Received from server: " + responseMessage);
            }

            // Close the client socket
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
