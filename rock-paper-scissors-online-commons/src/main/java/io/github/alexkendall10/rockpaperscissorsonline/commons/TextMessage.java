package io.github.alexkendall10.rockpaperscissorsonline.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class TextMessage implements Serializable {
    private String message;
}
