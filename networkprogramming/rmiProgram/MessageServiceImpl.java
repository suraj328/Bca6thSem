package rmiProgram;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {
    protected MessageServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String getMessage() throws RemoteException {
        return "Hello, client!";
    }
}
