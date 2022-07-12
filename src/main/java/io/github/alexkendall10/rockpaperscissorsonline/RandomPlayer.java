package io.github.alexkendall10.rockpaperscissorsonline;

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
