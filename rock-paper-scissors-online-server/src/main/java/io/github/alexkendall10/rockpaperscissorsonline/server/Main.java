package io.github.alexkendall10.rockpaperscissorsonline.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port = 7777;
        ClientsManager clientsManager = new ClientsManager(port);
        clientsManager.start();
    }
}
