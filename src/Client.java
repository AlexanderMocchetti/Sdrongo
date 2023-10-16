import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        PrintWriter serverOut =
                new PrintWriter(socket.getOutputStream(), true);
        BufferedReader serverIn =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn =
                new BufferedReader(
                        new InputStreamReader(System.in));
        System.out.println(serverIn.readLine());

        String messaggioClient = stdIn.readLine();
        serverOut.println(messaggioClient);

        String indovinello = stdIn.readLine();
        serverOut.println(indovinello);

        System.out.println(serverIn.readLine());
    }
}