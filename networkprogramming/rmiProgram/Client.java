package rmiProgram;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the remote object from the RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MessageService messageService = (MessageService) registry.lookup("MessageService");

            // Call the remote method to get the message
            String message = messageService.getMessage();
            System.out.println("Server says: " + message);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

