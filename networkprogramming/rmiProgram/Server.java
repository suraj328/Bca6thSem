package rmiProgram;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            MessageService messageService = new MessageServiceImpl();

            // Bind the remote object to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MessageService", messageService);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

