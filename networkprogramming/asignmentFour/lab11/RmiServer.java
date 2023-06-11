package asignmentFour.lab11;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
public class RmiServer extends UnicastRemoteObject implements RmiServerIntf {
    public static final String MESSAGE = "Hello World";
    public RmiServer() throws RemoteException{
        super();
    }
    public String getMessage(){
        return MESSAGE;
    }
    public static void main(String[] args) {
        System.out.println("remi server started");
        try {
            // special eception handler for registry
            LocateRegistry.createRegistry(1099);
            System.out.println("java rmi registry created");
        } catch (RemoteException e) {
            //di nothing,error means register already exist
        }
    }
}
