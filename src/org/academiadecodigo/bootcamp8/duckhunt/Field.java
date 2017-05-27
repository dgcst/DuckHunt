package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.FieldRepresentation;

public class Field {

    private FieldRepresentation background;
    private int width;
    private int heigth;

    public Field() {
        background = new FieldRepresentation();
        background.init();
        this.width = background.getWidth();
        this.heigth = background.getHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }
}
