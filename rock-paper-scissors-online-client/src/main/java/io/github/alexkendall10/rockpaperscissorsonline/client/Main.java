package io.github.alexkendall10.rockpaperscissorsonline.client;

import io.github.alexkendall10.rockpaperscissorsonline.commons.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Main {
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 7777);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        InitialMessage initialMessage = new InitialMessage("Jaimito");
        objectOutputStream.writeObject(initialMessage);

        while (true) {
            Object object = objectInputStream.readObject();
            if (object instanceof WelcomeMessage welcomeMessage) {
                System.out.println(welcomeMessage.getWelcomeText());
            } else if (object instanceof TextMessage textMessage) {
                System.out.println(textMessage.getMessage());
            } else if (object instanceof ChooseMovementMessage) {
                Movement movement = chooseMovement();
                MovementMessage movementMessage = new MovementMessage(movement);
                objectOutputStream.writeObject(movementMessage);
            } else {
                break;
            }

        }
        objectOutputStream.close();
        objectInputStream.close();
        socket.close();
    }

    public static Movement chooseMovement() throws IOException {

        System.out.println("Introduce your movement (ROCK, PAPER or SCISSORS)");
        String selection = br.readLine().toUpperCase();


        return Movement.valueOf(selection);
    }
}
