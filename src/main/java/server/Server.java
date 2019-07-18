package server;

import domain.Mapa;
import domain.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by federicoberon on 12/07/2019.
 */
public class Server {

    private static String[] names = {"juan", "pedro", "jose"};

    private static int PORT = 8887;

    static List<User> users = new ArrayList<User>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket listener = new ServerSocket(PORT);

        while (true){
            Socket client = listener.accept();
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            User user = (User) input.readObject();
            System.out.println(user.getFirstName());
            input.close();
            users.add(user);

//            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
//            output.writeObject(new Mapa());
//            output.close();
        }

    }

    public static String getName(){
        return names[(int) (Math.random() * names.length)];
    }

}
