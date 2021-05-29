package server;
import common.RMIInterface;
import java.rmi.Naming;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RMIInterface {

    private File file;
    private String filePath = "archivo.txt";

    public static void main(String[] args) throws IOException {
        (new Server()).initServer();
    }
    public Server() throws IOException, RemoteException {
        super();
    }

    public void initServer() throws IOException, RemoteException {
        try {
            System.out.println("Inicializando Servidor...");
            Naming.rebind("logging", (RMIInterface) this);
            this.file = new File(this.filePath);
            this.file.createNewFile();
            System.out.println("Servidor Iniciado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String text) throws IOException {

        if ( text == null || text.trim().isEmpty() ) {
            throw new IOException("Mensaje no válido");
        }

        FileWriter writter = new FileWriter(file, true);
        writter.write(text + "\n" );
        writter.close();
    }

    @Override
    public String sendMessage(String content) throws RemoteException{

        try {
            this.writeFile(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Mensaje guardado con éxito";
    }

}
