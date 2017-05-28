package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuRepresentation implements Representable {

    private Picture menuBackground;

    @Override
    public void init() {
        menuBackground = new Picture(0, 0, "images/menu/menu.with.play.png");
        menuBackground.draw();
    }
}


