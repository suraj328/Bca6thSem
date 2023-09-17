//Write a program to create a socket to server.

import java.net.*;
import java.io.*;
// import java.net.ServerSocket;

public class ServerSocketA {

    public static void main(String[] args) {

        int serverPort = 1345;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is listenting on port: " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from client: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                // Read the client's message
                String message = in.readLine();
                System.out.println("Received message from client: " + message);

                // Send response to the client
                String response = "Hello Client!";
                out.println(response);
                out.flush();
                System.out.println("Send response to client: " + response);

                // Close the connection
                clientSocket.close();
                System.out.println("Connection closed");
            }
        } catch (IOException e) {
            System.err.println("Exception caught: " + e);
        }
    }
}