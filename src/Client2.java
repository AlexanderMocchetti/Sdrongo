import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);

        System.out.println("Connesso al server");

        PrintWriter serverOut =
                new PrintWriter(socket.getOutputStream(), true);
        BufferedReader serverIn =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn =
                new BufferedReader(
                        new InputStreamReader(System.in));


        String inputDaTastiera = stdIn.readLine();

        serverOut.println(inputDaTastiera);
    }
}
