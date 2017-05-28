package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 27/05/2017.
 */

public class DuckRepresentation implements MovableRepresentable {

    private Picture duck1;
    private Picture duck2;
    private Picture duck3;
    private int imageorder;
    private boolean dead;


    public DuckRepresentation(int duckSpawn, int speed) {
        duck1 = new Picture(0, duckSpawn, "media_files/images/duck1.png");
        duck2 = new Picture(0, duckSpawn, "media_files/images/duck2.png");
        duck3 = new Picture(0, duckSpawn, "media_files/images/duck3.png");
        imageorder = 0;
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
            if (imageorder == 0) {
                duck3.delete();
                duck1.translate(speed*3, 0);
                duck1.draw();
                imageorder = 1;
            } else if (imageorder == 1) {
                duck1.delete();
                duck2.translate(speed*3, 0);
                duck2.draw();
                imageorder = 2;
            } else if (imageorder == 2) {
                duck2.delete();
                duck3.translate(speed*3, 0);
                duck3.draw();
                imageorder = 0;
            }
        }
    }

    public void kill() {
        duck1.delete();
        duck2.delete();
        duck3.delete();
        dead = true;
        System.out.println("I am dead");
    }
}
