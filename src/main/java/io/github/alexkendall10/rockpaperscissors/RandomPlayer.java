package io.github.alexkendall10.rockpaperscissors;

import lombok.Getter;

import java.util.Random;

public class RandomPlayer extends AbstractPlayer {

    private final Random random = new Random();

    public RandomPlayer() {
        super("RandomPlayer");
    }

    @Override
    public Movement chooseMovement() {
        return Movement.values()[random.nextInt(3)];
    }

}
