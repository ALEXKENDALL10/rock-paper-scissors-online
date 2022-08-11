package io.github.alexkendall10.rockpaperscissorsonline.server;

import io.github.alexkendall10.rockpaperscissorsonline.commons.Movement;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;

@AllArgsConstructor
@Log
public class RockPaperScissorsGame implements Runnable {
    private Player player1;
    private Player player2;
    private int roundsNumber;


    public void play() throws IOException {

        player1.sendMessage("YOU ARE GOING TO PLAY ROCK-PAPER-SCISSORS. THE BEST OF " + roundsNumber + " ROUNDS WINS");
        player2.sendMessage("YOU ARE GOING TO PLAY ROCK-PAPER-SCISSORS. THE BEST OF " + roundsNumber + " ROUNDS WINS");

        for (int i = 1; i < (roundsNumber + 1) && !(player1.getWonRounds() > (roundsNumber / 2) || player2.getWonRounds() > (roundsNumber / 2)); i++) {
            log.info("STARTING ROUND NUMBER " + i + ":");
            player1.sendMessage("STARTING ROUND NUMBER " + i + ":");
            player2.sendMessage("STARTING ROUND NUMBER " + i + ":");
            while (!playRound()) {
                player1.sendMessage("RETRYING ROUND NUMBER " + i + ":");
                player2.sendMessage("RETRYING ROUND NUMBER " + i + ":");
            }
        }

        if (player1.getWonRounds() > player2.getWonRounds()) {
            player1.sendMessage("YOU WIN");
            player2.sendMessage("YOU LOSE");
        } else {
            player2.sendMessage("YOU WIN");
            player1.sendMessage("YOU LOSE");
        }
    }

    private boolean playRound() throws IOException {

        Movement m1p1 = player1.chooseMovement();
        Movement m1p2 = player2.chooseMovement();
        player2.sendMessage(player1.getName() + " HAS CHOSEN " + m1p1);
        player1.sendMessage(player2.getName() + " HAS CHOSEN " + m1p2);

        Winner winner = whoWinsARound(m1p1, m1p2);
        switch (winner) {
            case DRAW: {
                player1.sendMessage("DRAW");
                player2.sendMessage("DRAW");
                break;
            }
            case PLAYER_1:{
                player1.sendMessage("YOU WIN");
                player2.sendMessage("YOU LOSE");
                player1.addWonRound();
                break;
            }
            case PLAYER_2:{
                player1.sendMessage("YOU LOSE");
                player2.sendMessage("YOU WIN");
                player2.addWonRound();
                break;
            }
        }

        return winner != Winner.DRAW;
    }

    static Winner whoWinsARound(Movement move1, Movement move2) {
        if (move1.equals(move2))
            return Winner.DRAW;
        else if ((move1.ordinal() + 1) % 3 == move2.ordinal()) // (m1+1) %3 == m2 -> m2 wins
            return Winner.PLAYER_2;
        else
            return Winner.PLAYER_1;

    }

    @Override
    public void run() {
        try {
            play();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
