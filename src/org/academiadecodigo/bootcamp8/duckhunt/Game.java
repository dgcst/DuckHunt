package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjectsFactory;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Game {

    private Canvas canvas;
    private Duck[] ducks;
    private GameObjects[] specials;
    private Gun gun;
    private Field field;
    private Integer gameScore;
    private Text displayScore;
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
        gameScore = 0;
        gameLevel = 1;
        gun = new Gun();
        specials = new GameObjects[1];
        specials[0] = GameObjectsFactory.getNewSpecialObject();
        ducks = new Duck[4];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = GameObjectsFactory.getNewDuck();
        }
        specials = new GameObjects[1];
        scoreInit();
        welcomeMsg();
    }

    public void start() throws InterruptedException {
        while (true) {

            gun.resetX();
            gun.resetY();
            displayScore.setText("Score: " + gameScore.toString());
            Thread.sleep(110);

            moveAllDucks();
            if (specials[0] != null){
            specialsMove();
            }

            level();
            displayScore.draw();
        }
    }

    public void moveAllDucks() throws InterruptedException {
        for (int i = 0; i < ducks.length; i++) {
            if (ducks[i].getXOffSet() + ducks[i].getSpeed() >= field.getWidth() ||
                    ducks[i].getX() + ducks[i].getSpeed() <= 0) {
                ducks[i].kill();
                ducks[i] = GameObjectsFactory.getNewDuck();
                return;
            }

            if ((gun.getX() >= ducks[i].getX() && gun.getX() <= ducks[i].getXOffSet())
                    && gun.getY() >= ducks[i].getY() && gun.getY() <= ducks[i].getYOffSet()) {
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
        if (specials[i].getXOffSet() + specials[i].getSpeed() >= field.getWidth() || specials[i].getY() <= 0) {
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

    public void welcomeMsg() throws InterruptedException {
        Text text = new Text(580, 100, "Welcome to the VEGAN Duck Hunt");
        text.setColor(Color.BLACK);
        text.grow(400, 70);
        text.draw();
        Thread.sleep(3000);
        text.delete();
        Text text1 = new Text(600, 200, "Get Ready...");
        text1.setColor(Color.BLACK);
        text1.grow(200, 50);
        text1.draw();
        Thread.sleep(2000);
        text1.delete();
        Text text2 = new Text(600, 300, "GO!");
        text2.setColor(Color.BLACK);
        text2.grow(100, 25);
        text2.draw();
        Thread.sleep(1000);
        text2.delete();
    }

    public void scoreInit() {
        displayScore = new Text(120, 750, "Score: " + gameScore.toString());
        displayScore.setColor(Color.BLACK);
        displayScore.grow(80, 20);
    }
}

