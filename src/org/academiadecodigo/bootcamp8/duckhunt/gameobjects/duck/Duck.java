package org.academiadecodigo.bootcamp8.duckhunt.gameobjects.duck;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.GameObjects;
import org.academiadecodigo.bootcamp8.duckhunt.simplegfx.DuckRepresentation;
import org.academiadecodigo.bootcamp8.duckhunt.sound.Sound;

public class Duck extends GameObjects {
    private DuckType type;
    private DuckRepresentation duckPicture;
    private boolean dead;
    private int x;
    private int y;
    private static int duckSpawn = 0;
    private Sound duckSound;

    public Duck(DuckType type) {
        this.type = type;
        this.x = type.getxStart();
        this.y = duckSpawnY();
        this.duckPicture = new DuckRepresentation(type, y);
        duckSound = new Sound ("/resources/sounds/duck.wav");
        duckSound.setLoop(2);
        duckSound.play(false);
    }

    public void move() {
        duckPicture.move(getXSpeed(), getYSpeed());
        x += getXSpeed();
        y += getYSpeed();
    }

    public void kill() {
        duckSound.stop();
        dead = true;
        duckPicture.kill();
    }

    private int duckSpawnY() {
        if (duckSpawn == 0) {
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

    public int getKillPoints() {
        return type.getKillPoints();
    }

    public boolean isDead() {
        return dead;
    }

    public DuckType getType(){
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXOffSet() {
        return x + duckPicture.getOffsetX();
    }

    public int getYOffSet() {
        return y + duckPicture.getOffsetY();
    }

    public int getXSpeed() {
        return type.getxSpeed();
    }

    public int getYSpeed() { return type.getySpeed(); }
}
