package io.github.alexkendall10.rockpaperscissors;

import lombok.*;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Getter
@Setter
@Log
public class ConsolePlayer extends AbstractPlayer {

    public ConsolePlayer(String name) {
        super(name);
    }

    public Movement chooseMovement() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        log.info("Introduce your movement (ROCK, PAPER or SCISSORS)");
        String selection = br.readLine().toUpperCase();
        return Movement.valueOf(selection);
    }
}
