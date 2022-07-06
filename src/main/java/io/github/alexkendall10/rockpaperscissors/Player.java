package io.github.alexkendall10.rockpaperscissors;

import java.io.IOException;

public interface Player {
    Movement chooseMovement() throws IOException;
}
