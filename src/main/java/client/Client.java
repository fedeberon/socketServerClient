package client;

import server.ServerConection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by federicoberon on 12/07/2019.
 */
public class Client {

    public static final String SERVER_IP = "localhost";
    public static final int PORT = 8887;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, PORT);
        ServerConection serverConection = new ServerConection(socket);
        BufferedReader keyboard =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(serverConection).start();

        while (true){
            System.out.print(">");
            String command = keyboard.readLine();
            if (command.equals("quit")) break;
            out.println(command);
        }

        socket.close();
        System.exit(0);
    }
}
