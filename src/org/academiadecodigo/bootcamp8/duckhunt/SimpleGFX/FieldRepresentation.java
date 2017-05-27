package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 27/05/2017.
 */
public class FieldRepresentation implements Representable {

    @Override
    public void init() {
        Picture background = new Picture(0,0, "media_files/images/background.png");
        background.draw();
    }
}
