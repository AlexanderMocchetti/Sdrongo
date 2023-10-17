import java.net.*;
import java.io.*;

public class Server1 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();

        System.out.println("Connessione accettata");

        PrintWriter clientOut =
                new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader clientIn = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        clientOut.println("Benvenuto client!");
    }
}
