import java.net.*;
import java.io.*;
import java.util.Hashtable;

public class Server3 {
    public static void main(String[] args) throws IOException{

        Hashtable<String, String> tabellaIndovinelli = new Hashtable<>();

        tabellaIndovinelli.put("Qual'e il tuo cibo preferito?", "pizza");
        tabellaIndovinelli.put("Sei vivo?", "No, sono un server");


        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();

        System.out.println("Connessione accettata");

        PrintWriter clientOut =
                new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader clientIn = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        String indovinelloDaClient = clientIn.readLine();

        String rispostaAlIndovinello = tabellaIndovinelli.get(indovinelloDaClient);

        if(rispostaAlIndovinello == null)
            rispostaAlIndovinello = "Indovinello non trovato";

        clientOut.println(rispostaAlIndovinello);
    }
}
