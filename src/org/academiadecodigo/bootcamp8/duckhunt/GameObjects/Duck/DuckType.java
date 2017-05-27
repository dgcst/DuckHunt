package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;
// Created by dgcst on 25/05/17

public enum DuckType {
    NORMAL(35),
    FAST(50),
    SLOW(20);

    private int speed;

    DuckType(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
