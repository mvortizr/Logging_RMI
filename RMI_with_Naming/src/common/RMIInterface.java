package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public String sendMessage(String name) throws RemoteException;

}
