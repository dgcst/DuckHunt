package org.academiadecodigo.bootcamp8.duckhunt;
// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.DuckType;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Gun;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

import java.util.ArrayList;

public class Game {
    private Canvas canvas;
    private ArrayList<Shape> shapes;
    private Duck duck;
    private Gun gun;
    private Field field;


    public Game(){
        canvas = Canvas.getInstance();
        field = new Field();
        gun = new Gun();
        duck = new Duck(DuckType.NORMAL);
        shapes = new ArrayList<>();
    }

    public void start() throws InterruptedException {
        //shapes = canvas.getShapes();
        //shapes.clear();

        while ((duck.getX() + duck.getxLength()) < field.getWidth() && !duck.isDead()) {
            duck.move();
            Thread.sleep(100);
            if ((gun.getX() >= duck.getX() && gun.getX() <= duck.getxLength())
                    && gun.getY() >= duck.getY() && gun.getY() <= duck.getyHeight()) {
                duck.kill();
            }

        }

    }
}

