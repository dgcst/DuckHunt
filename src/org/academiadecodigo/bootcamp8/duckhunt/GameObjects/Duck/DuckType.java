package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;
// Created by dgcst on 25/05/17

public enum DuckType {
    NORMAL(2),
    FAST(3),
    SLOW(1);

    private int speed;

    DuckType(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
