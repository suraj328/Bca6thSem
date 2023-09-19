package nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NonBlockingIOServer {
    public static void main(String[] args) {
        try {
            // Create a server socket channel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
            serverSocketChannel.configureBlocking(false);

            // Create a selector for managing multiple channels
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server is listening on port 8080");

            while (true) {
                selector.select();

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        // Accept a new connection
                        SocketChannel clientSocketChannel = serverSocketChannel.accept();
                        clientSocketChannel.configureBlocking(false);
                        clientSocketChannel.register(selector, SelectionKey.OP_READ);

                        System.out.println("Accepted connection from: " + clientSocketChannel.getRemoteAddress());
                    } else if (key.isReadable()) {
                        // Read data from a connected client
                        SocketChannel clientSocketChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = clientSocketChannel.read(buffer);

                        if (bytesRead == -1) {
                            // Connection closed by the client
                            key.cancel();
                            clientSocketChannel.close();
                        } else if (bytesRead > 0) {
                            buffer.flip();
                            byte[] data = new byte[buffer.remaining()];
                            buffer.get(data);

                            String message = new String(data);
                            System.out.println("Received from client: " + message);

                            // Echo the message back to the client
                            clientSocketChannel.write(ByteBuffer.wrap(data));
                        }
                    }

                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

// // Set the SO_RCVBUF socket option to 1024 bytes.
// serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 1024);

// // Set the SO_SNDBUF socket option to 1024 bytes.
// serverSocketChannel.setOption(StandardSocketOptions.SO_SNDBUF, 1024);
