package org.academiadecodigo.bootcamp8.duckhunt.simplegfx;

import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.SpecialsType;
import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by prashanta on 28-05-2017.
 */
public class SpecialRepresentation implements MovableRepresentable {
    private Picture pic;
    private int moveFactor;


    public SpecialRepresentation(SpecialsType type) {
        pic = new Picture(type.getxStart(), type.getyStart(), type.getPic1());
        moveFactor = 0;
    }

    @Override
    public int getOffsetX() {
        return pic.getWidth();
    }

    @Override
    public int getOffsetY() {
        return pic.getHeight();
    }


    @Override
    public void move(int xSpeed, int ySpeed) {
        if (moveFactor == 0){
            pic.draw();
            moveFactor = 1;
        } else {
            pic.translate(xSpeed, ySpeed);
        }
    }

    @Override
    public void kill() {
        pic.delete();
    }
}


