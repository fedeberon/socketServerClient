package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ISFDyT Nº 27 on 17/07/2019.
 */
public class ServerConection implements Runnable {

    private Socket server;
    private BufferedReader in;
    private PrintWriter out;

    public ServerConection(Socket s) throws IOException {
        this.server = s;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        out = new PrintWriter(server.getOutputStream(), true);

    }

    public void run() {
            try {
                while (true) {
                    String serverResponse = in.readLine();
                    System.out.println("Server says : " + serverResponse);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                try {
                    in.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

    }
}
