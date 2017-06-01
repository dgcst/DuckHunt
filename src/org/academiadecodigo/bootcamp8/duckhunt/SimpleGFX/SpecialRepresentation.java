package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.SpecialsType;
import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by prashanta on 28-05-2017.
 */
public class SpecialRepresentation implements MovableRepresentable {
    private Picture pic;
    private int moveFactor;
    private boolean dead;


    public SpecialRepresentation(SpecialsType type) {
        pic = new Picture(type.getxStart(), type.getyStart(), type.getPic1());
        moveFactor = 0;
    }

    public int getOffsetX() {
        return pic.getWidth();
    }

    public int getOffsetY() {
        return pic.getHeight();
    }

    @Override
    public void init() {
    }

    @Override
    public void move(int xSpeed, int ySpeed) {
        if (!dead) {
            if (moveFactor == 0){
                pic.draw();
                moveFactor = 1;
            } else {
                pic.translate(xSpeed, ySpeed);
            }
        }
    }

    public void kill() {
        pic.delete();
        dead = true;
    }
}


