package org.academiadecodigo.bootcamp8.duckhunt.gameobjects;
// Created by dgcst on 25/05/17

public abstract class GameObjects {


    public abstract void move();

    public abstract void kill();

    public abstract boolean isDead();

    public abstract int getX();

    public abstract int getY();

    public abstract int getXOffSet();

    public abstract int getYOffSet();

    public abstract int getXSpeed();

    public abstract int getYSpeed();
}
