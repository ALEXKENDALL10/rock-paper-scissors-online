package io.github.alexkendall10.rockpaperscissorsonline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsGameTest {

    @Test
    void whoWinsARoundTest() {
        //Given
        Movement movement1 = Movement.ROCK;
        Movement movement2 = Movement.PAPER;
        //When
        Winner winner = RockPaperScissorsGame.whoWinsARound(movement1,movement2);

        //Then
        assertEquals(Winner.PLAYER_2,winner);
    }

    @ParameterizedTest
    @MethodSource("whoWinsCombinations")
    void whoWinsARoundParameterizedTest(Movement movement1,Movement movement2,Winner winner) {
        //When
        Winner actualWinner = RockPaperScissorsGame.whoWinsARound(movement1,movement2);
        //Then
        assertEquals(winner,actualWinner);
    }
    private static Stream<Arguments> whoWinsCombinations() {
        return Stream.of(
                Arguments.of(Movement.ROCK,Movement.PAPER, Winner.PLAYER_2),
                Arguments.of(Movement.ROCK,Movement.SCISSORS, Winner.PLAYER_1),
                Arguments.of(Movement.ROCK,Movement.ROCK, Winner.DRAW),
                Arguments.of(Movement.PAPER,Movement.ROCK, Winner.PLAYER_1),
                Arguments.of(Movement.PAPER,Movement.SCISSORS, Winner.PLAYER_2),
                Arguments.of(Movement.PAPER,Movement.PAPER, Winner.DRAW),
                Arguments.of(Movement.SCISSORS,Movement.PAPER, Winner.PLAYER_1),
                Arguments.of(Movement.SCISSORS,Movement.ROCK, Winner.PLAYER_2),
                Arguments.of(Movement.SCISSORS,Movement.SCISSORS, Winner.DRAW)

        );
    }

}