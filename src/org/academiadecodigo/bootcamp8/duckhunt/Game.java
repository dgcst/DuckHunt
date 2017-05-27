package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjectsFactory;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Gun;
import org.academiadecodigo.simplegraphics.graphics.Canvas;


public class Game {
    private Canvas canvas;
    private Duck[] ducks;
    private Gun gun;
    private Field field;


    public Game() {
        canvas = Canvas.getInstance();
        field = new Field();
        gun = new Gun();
    }

    public void init() {

        ducks = new Duck[3];

        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = GameObjectsFactory.getNewDuck();
        }
    }

    public void start() throws InterruptedException {
        while (true) {

            //Thread.sleep(50);
            moveAllDucks();
        }
    }

    public void moveAllDucks() throws InterruptedException {
        for (Duck duck : ducks) {
            if (duck.getXLength() + duck.getSpeed() < field.getWidth() && !duck.isDead()) {
                duck.move();
            }
            if ((gun.getX() >= duck.getX() && gun.getX() <= duck.getXLength())
                    && gun.getY() >= duck.getY() && gun.getY() <= duck.getYHeight()) {
                duck.kill();
            }

        }
    }
}

