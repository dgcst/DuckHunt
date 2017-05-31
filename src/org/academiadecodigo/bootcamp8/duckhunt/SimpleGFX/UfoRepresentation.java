package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by prashanta on 28-05-2017.
 */
public class UfoRepresentation implements MovableRepresentable {
    private Picture ufo;
    private int moveFactor;
    private boolean dead;


    public UfoRepresentation(int y, int speed) {
        ufo = new Picture(0, y, "resources/images/game/specials/ufo-down.png");
        moveFactor = 0;
    }

    public int getOffsetX() {
        return ufo.getWidth();
    }

    public int getOffsetY() {
        return ufo.getHeight();
    }

    @Override
    public void init() {
    }

    @Override
    public void move(int speed) {
        if (!dead) {
            if (moveFactor == 0){
                ufo.draw();
                moveFactor = 1;
            } else {
                ufo.translate(speed, -25);
            }
        }
    }

    public void kill() {
        ufo.delete();
        dead = true;
    }
}


