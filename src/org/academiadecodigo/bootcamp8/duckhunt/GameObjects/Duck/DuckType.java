package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;
// Created by dgcst on 25/05/17

public enum DuckType {
    NORMAL(20, 100),
    FAST(40, 200),
    SLOW(10, 10),
    SPECIAL(50, 1000);

    private int speed;
    private int killPoints;

    DuckType(int speed, int points) {
        this.speed = speed;
        killPoints = points;
    }

    public int getSpeed() {
        return speed;
    }

    public int getKillPoints() {
        return killPoints;
    }
}
