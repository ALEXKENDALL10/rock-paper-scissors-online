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
        System.out.println("Introduce your movement (rock, paper or scissors)");
        String election = scanner.nextLine();
        scanner.close();
        return Movement.valueOf(election);
    }
}
