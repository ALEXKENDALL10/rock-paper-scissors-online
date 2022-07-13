package io.github.alexkendall10.rockpaperscissorsonline.server;

import io.github.alexkendall10.rockpaperscissorsonline.commons.Movement;
import lombok.Getter;



import java.io.IOException;


@Getter

public class Player{

    private String name;
    private int wonRounds;

    public void addWonRound(){
        wonRounds++;
    }
    Movement chooseMovement() throws IOException{
        return Movement.ROCK;
    }

}
