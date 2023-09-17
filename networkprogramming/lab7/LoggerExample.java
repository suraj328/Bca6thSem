package lab7;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {

    private static final Logger logger = Logger.getLogger(LoggerExample.class.getName());

    public static void main(String[] args) throws IOException {
        // Create a socket.
        Socket socket = new Socket("localhost", 8080);

        // Log a message when the socket is connected.
        logger.log(Level.INFO, "Socket connected to localhost:8080");

        // Send a message to the server.
        socket.getOutputStream().write("Hello, world!".getBytes());

        // Receive a message from the server.
        byte[] bytes = new byte[1024];
        int bytesRead = socket.getInputStream().read(bytes);

        // Log a message when the message is received.
        logger.log(Level.INFO, "Message received from the server: " + new String(bytes, 0, bytesRead));

        // Close the socket.
        socket.close();
    }
}
// List<LogRecord> logRecords = logger.getAllLogRecords();

// Iterate over the log records and print the messages to the console.
// for (LogRecord logRecord : logRecords) {
// System.out.println(logRecord.getMessage());
// }