package io.github.alexkendall10.rockpaperscissorsonline.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class WelcomeMessage implements Serializable {
    private String welcomeText;

    public WelcomeMessage(String playerName){
        welcomeText = "Welcome to the game " + playerName;
    }
}
