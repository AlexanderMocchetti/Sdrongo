import java.net.*;
import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class Server {
    public static void main(String[] args) throws IOException {

        Hashtable<String, String> table = new Hashtable<>(Map.of(
                "Ciucciamelo?", "no",
                "Porco dio?", "si",
                "Marra", "Gay"
        ));

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        PrintWriter clientOut =
                new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader clientIn = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("laksnd");
        clientOut.println("Benvenuto all'inferno merda");
        System.out.println(clientIn.readLine());

        String indovinelloClient = clientIn.readLine();

        String rispostaIndovinello = table.get(indovinelloClient);

        if (rispostaIndovinello == null)
            rispostaIndovinello = "Indovinello non trovato";

        clientOut.println(rispostaIndovinello);
    }
}