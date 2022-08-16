package io.github.alexkendall10.rockpaperscissorsonline.server;

import io.github.alexkendall10.rockpaperscissorsonline.commons.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


@RequiredArgsConstructor
public class Player {
    @Getter
    private final String name;
    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    @Getter
    private int wonRounds;

    public void addWonRound() {
        wonRounds++;
    }

    Movement getMovement() {
        try {
            MovementMessage movementMessage = (MovementMessage) objectInputStream.readObject();
            return movementMessage.getMovement();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendMessage(String s) {
        TextMessage textMessage = new TextMessage(s);
        try {
            objectOutputStream.writeObject(textMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void requestMovement() {
        ChooseMovementMessage chooseMovementMessage = new ChooseMovementMessage();
        try {
            objectOutputStream.writeObject(chooseMovementMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void finalMessage() {
        FinalMessage finalMessage = new FinalMessage();
        try {
            objectOutputStream.writeObject(finalMessage);
            objectOutputStream.flush();
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
