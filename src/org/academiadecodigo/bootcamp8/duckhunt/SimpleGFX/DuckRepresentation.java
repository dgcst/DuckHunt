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
    /*private int x;
    private int y;*/
    private boolean dead;


    public DuckRepresentation(int duckSpawn, int speed) {
        duck1 = new Picture(0, duckSpawn, "media_files/images/duck1.png");
        //System.out.println(duck1.getY());
        duck2 = new Picture(10, duckSpawn, "media_files/images/duck2.png");
       // System.out.println(duck2.getY());
        duck3 = new Picture(20, duckSpawn, "media_files/images/duck3.png");
       //System.out.println(duck3.getY());
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
    public void move(int speed) /*throws InterruptedException*/ {
        if (!dead) {
            if (imageorder == 0) {
                duck3.delete();
                duck1.translate(speed*3, 0);
                duck1.draw();
                System.out.println("printing speed " + speed + " x for duck1 " + duck1.getX());
                imageorder = 1;
            } else if (imageorder == 1) {
                duck1.delete();
                duck2.translate(speed*3, 0);
                duck2.draw();
                System.out.println("x for duck2 " + duck2.getX());
                imageorder = 2;
            } else if (imageorder == 2) {
                duck2.delete();
                duck3.translate(speed*3, 0);
                duck3.draw();
                System.out.println("x for duck3 " + duck3.getX());
                imageorder = 0;
            }


            /*else {
                imageorder = 0;
            }*/
            /*x += 20;
            Picture r = new Picture(x, y, "media_files/images/duck1.png");
            if (imageorder == 1)
                r = new Picture(x, y, "media_files/images/duck2.png");
            if (imageorder == 2)
                r = new Picture(x, y, "media_files/images/duck3.png");
            r.draw();
            imageorder++;
            if (imageorder == 3) {
                imageorder = 0;
            }
        }

    }

            int dx = speed;
            int sleepTime = 70;
            duck3.delete();
            duck1.draw();
            Thread.sleep(sleepTime);
            duck1.delete();
            duck2.translate(dx, 0);
            duck2.draw();
            Thread.sleep(sleepTime);
            duck2.delete();
            duck3.translate(dx, 0);
            duck3.draw();
            Thread.sleep(sleepTime);
            duck3.delete();
            duck1.translate(dx, 0);*/
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
