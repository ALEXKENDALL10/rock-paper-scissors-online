package io.github.alexkendall10.rockpaperscissors;

public class Main {

    public static void main(String[] args) {

        RockPaperScissorsGame game1 = new RockPaperScissorsGame(new RandomPlayer(), new ConsolePlayer("Fulanito"), 5);
        game1.play();
    }
}
