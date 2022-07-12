package io.github.alexkendall10.rockpaperscissorsonline;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        RockPaperScissorsGame game1 = new RockPaperScissorsGame(new RandomPlayer(), new ConsolePlayer("Fulanito"), 5);
        game1.play();
    }
}
