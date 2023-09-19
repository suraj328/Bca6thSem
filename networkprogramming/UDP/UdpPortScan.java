package UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpPortScan {

    public static void main(String[] args) throws IOException {
        // Create a DatagramSocket.
        DatagramSocket socket = new DatagramSocket();

        // Create a DatagramPacket to send data.
        byte[] data = new byte[1];
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 1);

        // Scan the ports from 1 to 65535.
        for (int i = 1; i <= 65535; i++) {
            // Set the port number of the DatagramPacket.
            packet.setPort(i);

            // Send the DatagramPacket.
            socket.send(packet);

            // Receive the response from the server.
            byte[] receivedData = new byte[1];
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(receivedPacket);

            // If a response is received, the port is open.
            if (receivedPacket.getPort() == i) {
                System.out.println("Port " + i + " is open.");
            }
        }

        // Close the socket.
        socket.close();
    }
}
