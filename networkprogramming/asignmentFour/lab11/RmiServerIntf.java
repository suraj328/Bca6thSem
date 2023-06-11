package asignmentFour.lab11;

/**
 * RmiServerIntf
 */
import java.rmi.*;
public interface RmiServerIntf {
    public String getMessage() throws RemoteException;
    
}