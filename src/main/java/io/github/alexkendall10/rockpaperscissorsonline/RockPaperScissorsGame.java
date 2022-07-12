package io.github.alexkendall10.rockpaperscissorsonline;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;

@AllArgsConstructor
@Log
public class RockPaperScissorsGame {
    private AbstractPlayer player1;
    private AbstractPlayer player2;
    private int roundsNumber;


    public void play() throws IOException {
        log.info("YOU ARE GOING TO PLAY ROCK-PAPER-SCISSORS. THE BEST OF " + roundsNumber + " ROUNDS WINS");

        for (int i = 1; i < (roundsNumber+1) && !(player1.getWonRounds() > (roundsNumber / 2) || player2.getWonRounds() > (roundsNumber / 2)); i++) {
            log.info("STARTING ROUND NUMBER " + i + ":");
            while (!playRound()) {
                log.info("RETRYING ROUND NUMBER " + i + ":");
            }
        }
        AbstractPlayer winnerPlayer = player1.getWonRounds() > player2.getWonRounds() ? player1 : player2;
        log.info("THE WINNER IS " + winnerPlayer.getName());
    }


    private boolean playRound() throws IOException {

        Movement m1p1 = player1.chooseMovement();
        Movement m1p2 = player2.chooseMovement();
        log.info(player1.getName() + " HAS CHOSEN " + m1p1);
        log.info(player2.getName() + " HAS CHOSEN " + m1p2);

        Winner winner = whoWinsARound(m1p1, m1p2);
        log.info("THE WINNER IS " + winner);
        if (winner == Winner.PLAYER_1) {
            player1.addWonRound();
        } else if (winner == Winner.PLAYER_2) {
            player2.addWonRound();
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
}
