import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

/**
 * One
 */
// wap to create socket to client
public class One {

    public static void main(String[] args) {
        String serverHostname = "localhsot";
        int serverPort = 135;
        try {
            Socket clientSocket = new Socket(serverHostname, serverPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            // Send a message to the server
            String message = "hello, server";
            out.println(message);
            out.flush();
            System.out.println("sent message to server" + message);

            // read the server's response
            String response = in.readLine();
            System.out.println("Recived response from server" + response);

            clientSocket.close();
            System.out.println("connection closed");
        
        } catch (Exception e) {
            System.out.println("Erroe +"+e);
        }
    }
}