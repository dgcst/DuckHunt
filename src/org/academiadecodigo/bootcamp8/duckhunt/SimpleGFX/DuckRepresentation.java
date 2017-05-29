package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class DuckRepresentation implements MovableRepresentable {
    private Picture duck1;
    private Picture duck2;
    private Picture duck3;
    private int imageOrder;
    private boolean dead;


    public DuckRepresentation(int xStart, int duckSpawn, int speed) {
        duck1 = new Picture(xStart, duckSpawn, "images/duck1.png");
        duck2 = new Picture(xStart, duckSpawn, "images/duck2.png");
        duck3 = new Picture(xStart, duckSpawn, "images/duck3.png");
        imageOrder = 0;
    }

    public int getOffsetX() {
        return duck1.getWidth();
    }

    public int getOffsetY() {
        return duck1.getHeight();
    }

    @Override
    public void init() {
    }

    @Override
    public void move(int speed) {
        if (!dead) {
            if (imageOrder == 0) {
                duck3.delete();
                duck1.translate(speed*3, 0);
                duck1.draw();
                imageOrder = 1;
            } else if (imageOrder == 1) {
                duck1.delete();
                duck2.translate(speed*3, 0);
                duck2.draw();
                imageOrder = 2;
            } else if (imageOrder == 2) {
                duck2.delete();
                duck3.translate(speed*3, 0);
                duck3.draw();
                imageOrder = 0;
            }
        }
    }

    public void kill() {
        duck1.delete();
        duck2.delete();
        duck3.delete();
        dead = true;
    }
}
