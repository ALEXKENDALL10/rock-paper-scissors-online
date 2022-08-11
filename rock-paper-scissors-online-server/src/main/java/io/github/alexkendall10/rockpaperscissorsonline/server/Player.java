package io.github.alexkendall10.rockpaperscissorsonline.server;

import io.github.alexkendall10.rockpaperscissorsonline.commons.Movement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.io.IOException;
import java.net.Socket;


@Getter
@RequiredArgsConstructor
public class Player{

    private final String name;
    private final Socket socket;
    private int wonRounds;

    public void addWonRound(){
        wonRounds++;
    }
    Movement chooseMovement() throws IOException{
        return Movement.ROCK;
    }

}
