package org.academiadecodigo.bootcamp8.duckhunt.gameobjects;
// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.simplegfx.FieldRepresentation;

public enum SpecialsType {
    UFO(0, 600, 30, -25, "resources/images/game/specials/ufo-down.png", "/resources/sounds/ufo.wav" ),
    CATARINA(FieldRepresentation.getFieldWidth()-180, 500, -25, -10,
            "resources/images/game/specials/planecatarina.png" , "/resources/sounds/airplane.wav");

    private int xStart;
    private int yStart;
    private int xSpeed;
    private int ySpeed;
    private String pic1;
    private String sound;

    SpecialsType(int xStart, int yStart, int xSpeed, int ySpeed, String picSource, String soundSource) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        pic1 = picSource;
        sound = soundSource;
    }

    public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public String getPic1() {
        return pic1;
    }

    public String getSound() {
        return sound;
    }
}
