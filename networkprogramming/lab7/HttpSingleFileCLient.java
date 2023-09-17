package lab7;

/**
 * HttpSingleFileCLient
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpSingleFileCLient{

    public static void main(String[] args) throws IOException {
        // Create a socket to the server socket on port 8080.
        Socket socket = new Socket("localhost", 8080);

        // Get the output stream for the socket.
        OutputStream outputStream = socket.getOutputStream();

        // Send the HTTP GET request to the server.
        outputStream.write("GET / HTTP/1.1\r\nHost: localhost:8080\r\n\r\n".getBytes());
        outputStream.flush();

        // Get the input stream for the socket.
        InputStream inputStream = socket.getInputStream();

        // Read the HTTP response from the server.
        byte[] responseBytes = new byte[1024];
        int bytesRead = inputStream.read(responseBytes);

        // Parse the HTTP response.
        String response = new String(responseBytes, 0, bytesRead);
        String[] responseParts = response.split("\r\n");

        // Get the HTTP response status code.
        int statusCode = Integer.parseInt(responseParts[0].split(" ")[1]);

        // If the HTTP response status code is 200 OK, then the request was successful and the body of the response contains the requested content.
        if (statusCode == 200) {
            // Print the body of the HTTP response to the console.
            System.out.println(responseParts[responseParts.length - 1]);
        } else {
            System.err.println("HTTP error code: " + statusCode);
        }

        // Close the socket.
        socket.close();
    }
}
