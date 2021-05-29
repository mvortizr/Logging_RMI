package RMIConnection;

import RMIConnection.RMIInterface;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;


public class Client {

    private static RMIInterface conn;
    private static String serverAddress = "localhost";
    private static int serverPort = 3232;
    private static String instructions =  "¿Qué deseas guardar?. Escribe \"salir\" para salir";

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry(serverAddress,serverPort);
        conn = (RMIInterface) (registry.lookup("logging"));

        while(true){

            String message = JOptionPane.showInputDialog(instructions);
            if (message == null || message.equals("salir")) return;
            String response = conn.sendMessage(message);
            JOptionPane.showMessageDialog(null, response);
        }
    }

}