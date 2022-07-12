package io.github.alexkendall10.rockpaperscissorsonline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter

public abstract class AbstractPlayer implements Player {

    private final String name;
    private int wonRounds;

    public void addWonRound(){
        wonRounds++;
    }


}
