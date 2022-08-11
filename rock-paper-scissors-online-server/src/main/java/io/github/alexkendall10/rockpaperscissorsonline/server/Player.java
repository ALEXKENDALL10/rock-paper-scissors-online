package io.github.alexkendall10.rockpaperscissorsonline.server;

import io.github.alexkendall10.rockpaperscissorsonline.commons.Movement;
import io.github.alexkendall10.rockpaperscissorsonline.commons.MovementMessage;
import io.github.alexkendall10.rockpaperscissorsonline.commons.TextMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



@RequiredArgsConstructor
public class Player{
    @Getter
    private final String name;
    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    @Getter
    private int wonRounds;

    public void addWonRound(){
        wonRounds++;
    }
    Movement chooseMovement() {
        try {
            MovementMessage movementMessage = (MovementMessage)objectInputStream.readObject();
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
}
