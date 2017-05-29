package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldRepresentation implements Representable {
    //public static int fieldWidth;
    private Picture background;

    @Override
    public void init() {
        background = new Picture(0,0, "images/background-up-clouds.png");
        //fieldWidth = background.getWidth();
        background.draw();

    }

    /*public static int getFieldWidth(){
        return fieldWidth;
    }*/

    public int getWidth() {
        return background.getWidth();
    }

    public int getHeight() {
        return background.getHeight();
    }
}
