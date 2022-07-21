package io.github.alexkendall10.rockpaperscissorsonline.client;

import io.github.alexkendall10.rockpaperscissorsonline.commons.InitialMessage;
import io.github.alexkendall10.rockpaperscissorsonline.commons.WelcomeMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost",7777);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        InitialMessage initialMessage = new InitialMessage("Jaimito");
        objectOutputStream.writeObject(initialMessage);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        WelcomeMessage welcomeMessage =(WelcomeMessage)objectInputStream.readObject();
        System.out.println(welcomeMessage.getWelcomeText());
    }
}
