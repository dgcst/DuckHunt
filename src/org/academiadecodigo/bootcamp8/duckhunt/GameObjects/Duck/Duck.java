package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.DuckRepresentation;

public class Duck extends GameObjects {

    private DuckType type;
    private int speed;
    private DuckRepresentation duckPicture;
    private boolean dead;
    private int killPoints;
    private int x;
    private int y;
    private int xOffSet;
    private int yOffSet;
    public static int duckSpawn = 0;

    public Duck(DuckType type) {
        this.type = type;
        this.speed = type.getSpeed();
        this.killPoints = type.getKillPoints();
        this.x = 0;
        this.y = duckSpawnY();
        this.duckPicture = new DuckRepresentation(y, 0);
        this.xOffSet = x + duckPicture.getOffsetX();
        this.yOffSet = y + duckPicture.getOffsetY();

    }

    public int getKillPoints() {
        return killPoints;
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

    public int getXOffSet() {
        return xOffSet;
    }

    public int getYOffSet() {
        return yOffSet;
    }

    public int getSpeed() {
        return speed;
    }

    public void kill() {
        dead = true;
        duckPicture.kill();
    }

    private int duckSpawnY() {
        if(duckSpawn == 0){
            duckSpawn++;
            return 40;
        }
        if (duckSpawn == 1) {
            duckSpawn++;
            return 160;
        }
        if (duckSpawn == 2) {
            duckSpawn++;
            return 280;
        }
        duckSpawn = 0;
        return 400;
    }

    public void move(){
        if (!dead) {
            duckPicture.move(speed);
            //x +=  speed;
            xOffSet += speed;
        }
    }
}
