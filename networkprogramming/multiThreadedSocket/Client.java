package networkprogramming.multiThreadedSocket;
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while (true) {
                System.out.print("Enter a message: ");
                message = reader.readLine();
                writer.println(message);
                String response = serverReader.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
