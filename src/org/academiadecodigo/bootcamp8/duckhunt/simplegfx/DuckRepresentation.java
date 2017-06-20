package org.academiadecodigo.bootcamp8.duckhunt.simplegfx;

import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.duck.DuckType;
import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class DuckRepresentation implements MovableRepresentable {
    private Picture duck1;
    private Picture duck2;
    private Picture duck3;
    private int imageOrder;


    public DuckRepresentation(DuckType type, int duckSpawn) {
        duck1 = new Picture(type.getxStart(), duckSpawn, type.getPic1());
        duck2 = new Picture(type.getxStart(), duckSpawn, type.getPic2());
        duck3 = new Picture(type.getxStart(), duckSpawn, type.getPic3());
        imageOrder = 0;

    }

    @Override
    public int getOffsetX() {
        return duck1.getWidth();
    }

    @Override
    public int getOffsetY() {
        return duck1.getHeight();
    }

    @Override
    public void move(int xSpeed, int ySpeed) {
        if (imageOrder == 0) {
            duck3.delete();
            duck1.translate(xSpeed*3, ySpeed);
            duck1.draw();
            imageOrder = 1;
        } else if (imageOrder == 1) {
            duck1.delete();
            duck2.translate(xSpeed*3, ySpeed);
            duck2.draw();
            imageOrder = 2;
        } else if (imageOrder == 2) {
            duck2.delete();
            duck3.translate(xSpeed*3, ySpeed);
            duck3.draw();
            imageOrder = 0;
        }
    }


    @Override
    public void delete() {
        duck1.delete();
        duck2.delete();
        duck3.delete();
    }
}
