package lab7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NoBindServerSocket {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket without binding to a specific address and port
            ServerSocket serverSocket = new ServerSocket();

            // The serverSocket is not yet bound to any specific address or port

            System.out.println("ServerSocket created but not bound.");

            // You can later bind it to a specific address and port using the bind method
            serverSocket.bind(null); // Binds to a random available port on all network interfaces

            System.out.println("ServerSocket bound to port " + serverSocket.getLocalPort());

            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();

                // Handle client communication here
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
