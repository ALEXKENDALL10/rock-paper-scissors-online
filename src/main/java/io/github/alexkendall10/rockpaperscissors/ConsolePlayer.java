package io.github.alexkendall10.rockpaperscissors;

import lombok.*;

import java.util.Scanner;

@Getter
@Setter
public class ConsolePlayer extends AbstractPlayer {

    public ConsolePlayer(String name) {
        super(name);
    }

    public Movement chooseMovement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce your movement (ROCK, PAPER or SCISSORS)");
        String selection = scanner.nextLine().toUpperCase();
        scanner.close();
        return Movement.valueOf(selection);
    }
}
