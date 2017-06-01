package org.academiadecodigo.bootcamp8.duckhunt;
// Created by dgcst on 25/05/17

public interface MovableRepresentable extends Representable {

    void move(int xSpeed, int ySpeed);

    int getOffsetX();

    int getOffsetY();

}
