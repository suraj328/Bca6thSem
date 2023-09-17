package lab7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleHttpFileServer {

    public static void main(String[] args) throws IOException {
        // Create a server socket on port 8080.
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Accept an incoming connection.
            Socket socket = serverSocket.accept();

            // Get the input and output streams for the socket.
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Read the HTTP request from the client.
            byte[] requestBytes = new byte[1024];
            int bytesRead = inputStream.read(requestBytes);

            // Parse the HTTP request.
            String request = new String(requestBytes, 0, bytesRead);
            String[] requestParts = request.split("\r\n");

            // Get the HTTP request method and URI.
            String method = requestParts[0].split(" ")[0];
            String uri = requestParts[0].split(" ")[1];

            // Handle the HTTP request.
            if (method.equals("GET") && uri.equals("/")) {
                // Send the index.html file to the client.
                outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                outputStream.write("Content-Type: text/html\r\n\r\n".getBytes());
                outputStream.write("<html><head><title>Single File HTTP Server</title></head><body><h1>Hello, world!</h1></body></html>".getBytes());
                outputStream.flush();
            } else {
                // Send a 404 Not Found response to the client.
                outputStream.write("HTTP/1.1 404 Not Found\r\n".getBytes());
                outputStream.write("Content-Type: text/plain\r\n\r\n".getBytes());
                outputStream.write("404 Not Found".getBytes());
                outputStream.flush();
            }

            // Close the socket.
            socket.close();
        }
    }
}



