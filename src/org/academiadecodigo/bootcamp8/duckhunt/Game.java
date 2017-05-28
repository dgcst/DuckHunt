package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjectsFactory;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Gun;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Game {
    private Canvas canvas;
    private Duck[] ducks;
    private Gun gun;
    private Field field;
    private Integer gameScore;
    private Text displayScore;


    public Game() {
        canvas = Canvas.getInstance();
        field = new Field();
        gun = new Gun();
        gameScore = 0;
    }

    public void init() throws InterruptedException {
        ducks = new Duck[4];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = GameObjectsFactory.getNewDuck();
        }
        scoreInit();
        welcomeMsg();
    }

    public void start() throws InterruptedException {
        while (true) {

            displayScore.setText("Score: " + gameScore.toString());
            Thread.sleep(90);

            moveAllDucks();
            displayScore.draw();

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

    public void welcomeMsg() throws InterruptedException {
        Text text = new Text(550, 200, "Welcome to the VEGAN Duck Hunt");
        text.setColor(Color.BLACK);
        text.grow(400, 100);
        text.draw();
        Thread.sleep(3000);
        text.delete();
        Text text1 = new Text(600, 200, "Get Ready...");
        text1.setColor(Color.BLACK);
        text1.grow(200, 50);
        text1.draw();
        Thread.sleep(2000);
        text1.delete();
        Text text2 = new Text(600, 200, "GO!");
        text2.setColor(Color.BLACK);
        text2.grow(100, 25);
        text2.draw();
        Thread.sleep(1000);
        text2.delete();
    }

    public void scoreInit(){
        displayScore = new Text(60, 680, "Score: " + gameScore.toString());
        displayScore.setColor(Color.BLACK);
        displayScore.grow(50, 10);
    }
}

