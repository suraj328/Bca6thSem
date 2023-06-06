package lab9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

public class OneUdpClientServer {
    public static void main(String[] args) {
        //define server port
        int serverPort = 12345;
        try {
            //create a udp socket
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            System.out.println("Udp server  is running  and listenning on port"+serverPort);
            while(true){
                // create a bufffer tp recive incomming request
                byte [] reciveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(reciveData,reciveData.length);
                // Recive the  packet from the client
                serverSocket.receive(receivePacket);
                // get the client ip address and port
                Inet4Address clientAddress = (Inet4Address) receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // convert the recived data to a string
                String clientMessage = new String(receivePacket.getData()).trim();
                //process the message
                String serverResponse = "Hello, client ! Your message has been recived";
                // convert the byte to response 
                byte[]sendData = serverResponse.getBytes();
                // creates a udp packet with the servers response

                // create udp  packet with server  response 
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,clientAddress,clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
