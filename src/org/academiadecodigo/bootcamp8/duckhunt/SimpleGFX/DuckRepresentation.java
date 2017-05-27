package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 27/05/2017.
 */

public class DuckRepresentation implements MovableRepresentable {

    private Picture duck1 = new Picture(10, 200, "media_files/images/duck1.png");
    private Picture duck2 = new Picture(20, 200, "media_files/images/duck2.png");
    private Picture duck3 = new Picture(30, 200, "media_files/images/duck3.png");

    @Override
    public void init() {

    }

    @Override
    public void move() {

        int dx = 60;
        int sleepTime = 90;
        while (true) {
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
            duck1.translate(dx, 0);
        }
    }
}
