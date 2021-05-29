package RMIConnection;
import java.net.InetAddress;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RMIInterface {

    private File file;
    private String filePath = "archivo.txt";
    private final int PORT =3232;

    public static void main(String[] args) throws IOException {
        (new Server()).initServer();
    }
    public Server() throws IOException, RemoteException {
        super();
    }

    public void initServer() throws IOException, RemoteException {
        try {
            System.out.println("Inicializando Servidor...");
            String IPadd = (InetAddress.getLocalHost()).toString();
            System.out.println("Escuchando en ..." + IPadd +":"+this.PORT);
            Registry registry = LocateRegistry.createRegistry(this.PORT);
            registry.bind("logging", (RMIInterface) this);
            this.createFile();
            System.out.println("Servidor Iniciado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createFile() throws  IOException {
        this.file = new File(this.filePath);
        this.file.createNewFile();
    }

    private void writeFile(String message) throws IOException {

        if ( message == null || message.trim().isEmpty() ) {
            throw new IOException("Mensaje no válido");
        }

        FileWriter writer = new FileWriter(file, true);
        writer.write(message + "\n" );
        writer.close();
    }

    @Override
    public String sendMessage(String content) throws RemoteException{

        try {
            this.writeFile(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Mensaje guardado en archivo";
    }

}
