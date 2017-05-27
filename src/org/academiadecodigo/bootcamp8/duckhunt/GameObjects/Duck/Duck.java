package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.DuckRepresentation;

public class Duck extends GameObjects {

    private DuckType type;
    private int speed;
    private DuckRepresentation duckPicture;
    private boolean dead;
    private int x;
    private int y;
    private int xLength;
    private int yHeight;

    public Duck(DuckType type) {
        this.type = type;
        this.speed = type.getSpeed();
        this.x = 10;
        this.y = 200; //duckSpawnY();
        this.xLength = x + 120;
        this.yHeight = y + 105;
        duckPicture = new DuckRepresentation();
        //duckPicture.init();
    }

    public boolean isDead() {
        return dead;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxLength() {
        return xLength;
    }

    public int getyHeight() {
        return yHeight;
    }

    public void kill() {
        dead = true;
        System.out.println("KILLLLLLLLLLED");
        duckPicture.kill();
    }

    public int duckSpawnY() {
        int random = (int) Math.random() * 2;

        switch (random) {
            case 0:
                return 60;
            case 1:
                return 330;
        }
        return 0;
    }

    public void move() throws InterruptedException {

        if (!dead) {
            duckPicture.move();
            x +=  20;
            xLength += 20;
            System.out.println(x + " duck position");
        }




    }


}
