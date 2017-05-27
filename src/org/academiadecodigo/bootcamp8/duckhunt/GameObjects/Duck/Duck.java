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
    public static int duckSpawn = 0;

    public Duck(DuckType type) {
        this.type = type;
        this.speed = type.getSpeed();
        this.x = 0;
        this.y = duckSpawnY();
        this.duckPicture = new DuckRepresentation(y);
        this.xLength = x + duckPicture.getOffsetX();
        this.yHeight = y + duckPicture.getOffsetY();

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

    public int getXLength() {
        return xLength;
    }

    public int getYHeight() {
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

    private int duckSpawnY() {
        if(duckSpawn == 0){
            duckSpawn++;
            return 60;
        }
        if (duckSpawn == 1) {
            duckSpawn++;
            return 200;
        }
        duckSpawn = 0;
        return 330;

    }

    public void move() throws InterruptedException {

        if (!dead) {
            duckPicture.move(speed);
            x +=  speed;
            xLength += speed;
            System.out.println(x + " duck position");
            System.out.println(y + " y duck");
        }




    }


}
