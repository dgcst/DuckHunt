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
    private int gameScore;


    public Game() {
        canvas = Canvas.getInstance();
        field = new Field();
        gun = new Gun();
    }

    public void init() {

        ducks = new Duck[4];

        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = GameObjectsFactory.getNewDuck();
        }
    }

    public void start() throws InterruptedException {
        while (true) {

            Thread.sleep(100);


            moveAllDucks();
            System.out.println(gameScore + " is your game score");
        }
    }

    public void moveAllDucks() throws InterruptedException {
        for (int i = 0; i < ducks.length; i++) {
            if (ducks[i].getXOffSet() + ducks[i].getSpeed() >= field.getWidth()) {
                ducks[i].kill();
                ducks[i] = GameObjectsFactory.getNewDuck();

                return;
            }
            if ((gun.getX() >= ducks[i].getX() && gun.getX() <= ducks[i].getXOffSet())
                    && gun.getY() >= ducks[i].getY() && gun.getY() <= ducks[i].getYOffSet()) {
                ducks[i].kill();
                ducks[i] = GameObjectsFactory.getNewDuck();
                gameScore += ducks[i].getKillPoints();
                return;
            }
            if (!ducks[i].isDead()){
                ducks[i].move();
            }

        }
    }
}

