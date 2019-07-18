package client;

import domain.Mapa;
import domain.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConectionClient {

    Socket socket;

    public ConectionClient() throws IOException {
        this.socket = new Socket("localhost", 8887);
    }

    public void enviarMensaje(User user) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeObject(user);
        output.close();
    }

    public Mapa getMapa() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        Mapa mapa = (Mapa) input.readObject();
        System.out.println(mapa);
        input.close();

        return mapa;
    }

}

