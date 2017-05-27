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
        this.x = 0;
        this.y = 200; //duckSpawnY();
        duckPicture = new DuckRepresentation();
        this.xLength = x + duckPicture.getOffsetX();
        this.yHeight = y + duckPicture.getOffsetY();

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

    public int getSpeed() {
        return speed;
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
            duckPicture.move(speed);
            x +=  speed;
            xLength += speed;
            System.out.println(x + " duck position");
        }




    }


}
