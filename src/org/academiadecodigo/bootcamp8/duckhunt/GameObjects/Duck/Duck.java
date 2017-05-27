package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp8.duckhunt.MovableRepresentable;

public class Duck extends GameObjects {

    private DuckType type;
    private int speed;
    private MovableRepresentable duckPicture;
    private boolean dead;
    private int x;
    private int y;
    private int xArea;
    private int yArea;

    public Duck(DuckType type) {
        this.type = type;
        this.speed = type.getSpeed();
        this.x = 0;
        this.y = duckSpawnY();
        this.xArea = x + 120;
        this.yArea = y + 105;
        duckPicture.init();
    }

    public int duckSpawnY() {
        int random = (int) Math.random() * 2;

        switch (random) {
            case 0:
                return 60;
            case 1:
                return 330;
        }
        return 0;
    }

    public void move() {

        x += 180;

    }


}
