package io.github.alexkendall10.rockpaperscissorsonline.server;

import io.github.alexkendall10.rockpaperscissorsonline.commons.InitialMessage;
import io.github.alexkendall10.rockpaperscissorsonline.commons.WelcomeMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientsManager {

    ServerSocket serverSocket;

    public ClientsManager(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException, ClassNotFoundException {
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            InitialMessage initialMessage = (InitialMessage) objectInputStream.readObject();
            WelcomeMessage welcomeMessage = new WelcomeMessage(initialMessage.getPlayerName());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(welcomeMessage);
        }
    }
}
