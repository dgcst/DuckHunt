package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.DuckType;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Gun;
import org.academiadecodigo.simplegraphics.graphics.Canvas;


public class Game {
    private Canvas canvas;
    private Duck duck;
    private Gun gun;
    private Field field;


    public Game(){
        canvas = Canvas.getInstance();
        field = new Field();
        gun = new Gun();
        duck = new Duck(DuckType.NORMAL);
    }

    public void start() throws InterruptedException {
        Thread.sleep(1000);

        while (duck.getxLength() + duck.getSpeed() < field.getWidth() && !duck.isDead()) {
            duck.move();
            if ((gun.getX() >= duck.getX() && gun.getX() <= duck.getxLength())
                    && gun.getY() >= duck.getY() && gun.getY() <= duck.getyHeight()) {
                duck.kill();
            }

        }

    }
}

