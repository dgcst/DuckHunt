package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;
// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;

public class Duck extends GameObjects {

    private DuckType type;
    private int speed;
    private MovableRepresentable duckPicture;

    public Duck(DuckType type) {
        this.type = type;
        this.speed = type.getSpeed();
        duckPicture.init();
    }
}
