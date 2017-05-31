package org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck;
// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.Field;
import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.FieldRepresentation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum DuckType {
    NORMAL(0, 20, 0, 100, "images/duck1.png", "images/duck2.png", "images/duck3.png"),
    FAST(0, 40, 0, 200, "images/duck1.png", "images/duck2.png", "images/duck3.png"),
    SLOW(0, 10, 0, 10, "images/duck1.png", "images/duck2.png", "images/duck3.png"),
    SPECIAL(0, 50, 0, 1000, "images/duck1.png", "images/duck2.png", "images/duck3.png"),
    REVNORMAL(FieldRepresentation.getFieldWidth()-120, -20, 0, 100, "images/duck1-flipped.png", "images/duck2-flipped.png", "images/duck3-flipped.png" ),
    REVFAST(FieldRepresentation.getFieldWidth()-120, -40, 0, 200, "images/duck1-flipped.png", "images/duck2-flipped.png", "images/duck3-flipped.png"),
    REVSLOW(FieldRepresentation.getFieldWidth()-120, -10, 0, 10, "images/duck1-flipped.png", "images/duck2-flipped.png", "images/duck3-flipped.png"),
    REVSPECIAL(FieldRepresentation.getFieldWidth()-120, -50, 0, 1000, "images/duck1-flipped.png", "images/duck2-flipped.png", "images/duck3-flipped.png");

    //120 value above in REV ducks is the length of the picture of the Duck to be used. Update accordingly if pic chance
    private int xStart;
    private int xSpeed;
    private int ySpeed;
    private int killPoints;
    private String pic1;
    private String pic2;
    private String pic3;

    DuckType(int xStart, int xspeed, int yspeed, int points, String source1, String source2, String source3) {
        this.xStart = xStart;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
        killPoints = points;
        pic1 = source1;
        pic2 = source2;
        pic3 = source3;
    }

    public int getxStart() {
        return xStart;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public Integer getKillPoints() {
        return killPoints;
    }

    public String getPic1() {
        return pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public String getPic3() {
        return pic3;
    }
}
