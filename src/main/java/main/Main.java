package main;

import client.ConectionClient;
import domain.User;

import java.io.IOException;

public class Main {

    public static void  main(String[] args) throws IOException, ClassNotFoundException {
        ConectionClient conectionClient = new ConectionClient();
        User user = new User("fede", "beron", "fedeberon@hotmail.com");
        conectionClient.enviarMensaje(user);

    }

}
