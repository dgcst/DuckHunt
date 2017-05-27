package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 27/05/2017.
 */

public class DuckRepresentation implements MovableRepresentable {

    private Picture duck1;
    private Picture duck2;
    private Picture duck3;
    //private int imageorder;
    //private int x;
    //private int y;
    private boolean dead;


    public DuckRepresentation() {
        duck1 = new Picture(0, 200, "media_files/images/duck1.png");
        duck2 = new Picture(0, 200, "media_files/images/duck2.png");
        duck3 = new Picture(0, 200, "media_files/images/duck3.png");
        //imageorder = 0;
        //x = 0;
        //y = 200;

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
    public void move(int speed) throws InterruptedException {
        if (!dead) {
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

    }*/

            int dx = speed;
            int sleepTime = 90;
            duck1.draw();
            duck2.translate(dx, 0);
            Thread.sleep(sleepTime);
            duck1.delete();
            duck2.draw();
            duck3.translate(dx, 0);
            Thread.sleep(sleepTime);
            duck2.delete();
            duck3.draw();
            duck1.translate(dx, 0);
            Thread.sleep(sleepTime);
            duck3.delete();
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
