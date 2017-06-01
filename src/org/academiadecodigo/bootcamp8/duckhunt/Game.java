package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.DuckType;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjectsFactory;
import org.academiadecodigo.simplegraphics.graphics.Canvas;


public class Game {
    private Canvas canvas;
    private Duck[] ducks;
    private GameObjects[] specials;
    private Gun gun;
    private Field field;
    private Integer gameScore;
    private int gameLevel;
    private static int levelUp = 1500;

    public Game() {
        canvas = Canvas.getInstance();
    }

    public void menu() throws InterruptedException {
        Menu menu = new Menu();
        menu.menuSelection();
        init();
        start();
    }

    public void init() throws InterruptedException {
        field = new Field();
        gun = new Gun();
        gameScore = 0;
        gameLevel = 1;
        specials = new GameObjects[1];
        specials[0] = GameObjectsFactory.getNewSpecialObject();
        ducks = new Duck[4];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = GameObjectsFactory.getNewDuck();
        }
        specials = new GameObjects[1];
        field.scoreInit(gameScore);

    }

    public void start() throws InterruptedException {
        while (true) {

            gun.resetX();gun.resetY();
            field.updateScore(gameScore);
            Thread.sleep(110);

            moveAllDucks();
            if (specials[0] != null){
            specialsMove();
            }

            nightMode();
            level();
            field.drawScore();
        }

    }

    public void moveAllDucks() throws InterruptedException {
        for (int i = 0; i < ducks.length; i++) {
            if (ducks[i].getXOffSet() + ducks[i].getXSpeed() >= field.getWidth() ||
                    ducks[i].getXOffSet() < 0) {
                ducks[i].kill();
                ducks[i] = GameObjectsFactory.getNewDuck();
                return;
            }

            if (gun.isLoaded() && gun.getX() >= ducks[i].getX() && gun.getX() <= ducks[i].getXOffSet()
                    && gun.getY() >= ducks[i].getY() && gun.getY() <= ducks[i].getYOffSet()) {
                if (ducks[i].getType() == DuckType.WHITEDUCK || ducks[i].getType() == DuckType.REVWHITEDUCK){
                    gameOver();
                }
                ducks[i].kill();
                gameScore += ducks[i].getKillPoints();
                ducks[i] = GameObjectsFactory.getNewDuck();
                gun.resetX();gun.resetY();
                return;
            }

            if (!ducks[i].isDead()) {
                ducks[i].move();
            }
        }
    }

    public void specialsMove(){
        int i = 0;
        if (specials[i].getXOffSet() + specials[i].getXSpeed() >= field.getWidth() || specials[i].getY() <= 0) {
            specials[i].kill();
            return;
        }
        if (!specials[i].isDead()) {
            specials[i].move();
        }
    }


    public void level(){
        if (gameScore > levelUp * gameLevel) {
            specials[0] = GameObjectsFactory.getNewSpecialObject();
            gameLevel++;
        }
    }

    public void nightMode(){
        if (gameLevel % 5 == 0){
            field.setNightMode();
        } else {
            field.restoreDayMode();
        }
    }

    public void gameOver() throws InterruptedException{
        field.gameOver();
        menu();
    }
}

