package io.github.alexkendall10.rockpaperscissors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RockPaperScissorsGame {
    private AbstractPlayer player1;
    private AbstractPlayer player2;
    private int roundsNumber;

    public void play(){
        for(int i=0; i<roundsNumber;i++){
            playRound();
        }


    }

    private void playRound() {
        Movement m1p1 = player1.chooseMovement();

        Movement m1p2 = player2.chooseMovement();

    }
}
