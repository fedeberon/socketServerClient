package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by federicoberon on 12/07/2019.
 */
public class Client {

    public static final String SERVER_IP = "127.0.0.1";
    public static final int PORT = 8887;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, PORT);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (true){
            System.out.print(">");
            String command = keyboard.readLine();
            if (command.equals("quit")) break;
            out.println(command);
            String serverResponse = input.readLine();
            System.out.println(serverResponse);
        }

    }

}
