package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * Created by federicoberon on 12/07/2019.
 */
public class ClientHandler implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean active;

    private List<ClientHandler> clientHandlers;

    public ClientHandler(Socket clientSockeet, List<ClientHandler> clientHandlers) throws IOException {
        this.client = clientSockeet;
        this.clientHandlers  = clientHandlers;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    public void run() {

        try {
            while(true){
                String request = in.readLine();
                if(request.contains("name")){
                    out.println(Server.getName());
                }
                else if(request.contains("say")){
                    outToAll(request);
                }
                else {
                    out.println("Type tell me a name to get a random name ");
                }
            }

        } catch (IOException e) {
            System.err.print(e);
            e.printStackTrace();
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void outToAll(String msn){
        for(ClientHandler aClient : clientHandlers){
            aClient.out.println(msn);
        }
    }
}
