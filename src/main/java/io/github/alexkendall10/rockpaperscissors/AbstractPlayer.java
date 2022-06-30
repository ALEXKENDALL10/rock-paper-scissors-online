package io.github.alexkendall10.rockpaperscissors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class AbstractPlayer implements Player {
    @Getter
    @Setter
    private String name;
}
