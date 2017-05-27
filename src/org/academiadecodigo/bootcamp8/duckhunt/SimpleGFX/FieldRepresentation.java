package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 27/05/2017.
 */
public class FieldRepresentation implements Representable {

    private Picture background;
    //private int width;
    //private int heigth;

    @Override
    public void init() {
        background = new Picture(0,0, "media_files/images/background.png");
        //background = new Rectangle(0,0, 1200, 900);
        background.draw();

    }

    public int getWidth() {
        return background.getWidth();
    }

    public int getHeight() {
        return background.getHeight();
    }
}
