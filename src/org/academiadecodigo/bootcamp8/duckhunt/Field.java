package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.FieldRepresentation;

public class Field {

    private Representable background;

    public Field() {
        background = new FieldRepresentation();
        background.init();
    }
}
