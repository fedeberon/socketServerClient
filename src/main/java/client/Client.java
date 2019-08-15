package client;

import server.ServerConection;

import java.io.*;
import java.net.Socket;

/**
 * Created by federicoberon on 12/07/2019.
 */
public class Client {

    public static final String SERVER_IP = "localhost";
    public static final int PORT = 8887;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(SERVER_IP, PORT);
        ServerConection serverConection = new ServerConection(socket);
        BufferedReader keyboard =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        new Thread(serverConection).start();

        while (true){
            System.out.print(">");
            String command = keyboard.readLine();
            if (command.equals("quit")) break;
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Client message : " + command);
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            out.println(command);
        }

        socket.close();
        System.exit(0);
    }
}
