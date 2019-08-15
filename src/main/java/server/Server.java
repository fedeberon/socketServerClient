package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by federicoberon on 12/07/2019.
 */
public class Server {

    private static String[] names = {"juan", "pedro", "jose"};

    private static int PORT = 8887;

    private static List<ClientHandler> clientHandlers = new ArrayList<ClientHandler>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);


    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);

        while(true){
            System.out.println("[SERVER] Waiting for client connection .. ");
            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to client");
            ClientHandler clientThread = new ClientHandler(client, clientHandlers);
            clientHandlers.add(clientThread);
            pool.execute(clientThread);
        }
    }

    public static String getName(){
        return names[(int) (Math.random() * names.length)];
    }

}
