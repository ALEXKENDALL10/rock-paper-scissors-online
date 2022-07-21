package io.github.alexkendall10.rockpaperscissorsonline.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class InitialMessage implements Serializable {
    private String playerName;
}
