package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * OneUdpClientServer2
 */
// client
public class OneUdpClientServer2 {

    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int serverPort = 12345;
        try {
            // create a UDP socket
            DatagramSocket clientSocket = new DatagramSocket();
            // Get user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message = userInput.readLine();
            // convert the message to bytes
            byte[] sendData = message.getBytes();
            // create a udp packet with the server ip address ,port ,and message
            DatagramPacket receivePacket =  new DatagramPacket(sendData,sendData.length,InetAddress.getByName(serverIP), serverPort);
            //recive the servers response
            clientSocket.receive(receivePacket);
            //convert the response to a string  and display it
            String serverResponse = new String(receivePacket.getData());
            System.out.println("Response from server: "+ serverResponse.trim());
            // close the socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}