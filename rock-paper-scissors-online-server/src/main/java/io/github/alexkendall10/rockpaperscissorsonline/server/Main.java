package io.github.alexkendall10.rockpaperscissorsonline.server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        RockPaperScissorsGame game1 = new RockPaperScissorsGame(new Player(), new Player(), 5);
        game1.play();
    }
}
