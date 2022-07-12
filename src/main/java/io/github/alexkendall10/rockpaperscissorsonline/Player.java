package io.github.alexkendall10.rockpaperscissorsonline;

import java.io.IOException;

public interface Player {
    Movement chooseMovement() throws IOException;
}
