package RMIConnection;

import RMIConnection.RMIInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;


public class Client {

    private static RMIInterface conn;
    private static String instructions =  "¿Qué deseas guardar?. Escribe \"salir\" para salir";

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        conn = (RMIInterface) Naming.lookup("logging");

        while(true){
            String message = JOptionPane.showInputDialog(instructions);
            if ( message == null || message.equals("salir")) return;
            String response = conn.sendMessage(message);
            JOptionPane.showMessageDialog(null, response);
        }
    }

}