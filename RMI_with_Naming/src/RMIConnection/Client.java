package RMIConnection;

import RMIConnection.RMIInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;


public class Client {

    private static RMIInterface look_up;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        look_up = (RMIInterface) Naming.lookup("logging");

        while(true){
            String txt = JOptionPane.showInputDialog("¿Qué deseas guardar? (Escribe \"salir\" para salir)");
            if ( txt == null || txt.equals("salir")) return;
            String response = look_up.sendMessage(txt);
            JOptionPane.showMessageDialog(null, response);
        }
    }

}