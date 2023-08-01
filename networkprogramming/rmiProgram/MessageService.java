package rmiProgram;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageService extends Remote {
    String getMessage() throws RemoteException;
}
