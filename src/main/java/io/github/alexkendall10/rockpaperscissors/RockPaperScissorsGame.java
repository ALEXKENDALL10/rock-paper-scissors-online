package io.github.alexkendall10.rockpaperscissors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RockPaperScissorsGame {
    private AbstractPlayer player1;
    private AbstractPlayer player2;
    private int roundsNumber;

    public void play() {
        for (int i = 0; i < roundsNumber; i++) {
            while(!playRound());

        }


    }

    private boolean playRound() {
        Movement m1p1 = player1.chooseMovement();
        Movement m1p2 = player2.chooseMovement();

        Winner winner = whoWins(m1p1,m1p2);
        if(winner == Winner.PLAYER_1){
            player1.addWonRound();
        }
        else if (winner == Winner.PLAYER_2){
            player2.addWonRound();
        }
        return winner != Winner.DRAW;
    }

    private Winner whoWins(Movement move1, Movement move2) {
        if (move1.equals(move2))
            return Winner.DRAW;
        else if ((move1.ordinal() + 1) % 3 == move2.ordinal()) // (m1+1) %3 == m2 -> m2 wins
            return Winner.PLAYER_2;
        else
            return Winner.PLAYER_1;

    }
}
