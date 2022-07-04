package io.github.alexkendall10.rockpaperscissors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter

public abstract class AbstractPlayer implements Player {

    private final String name;
    private int wonRounds;

    public void addWonRound(){
        wonRounds++;
    }


}
