package org.academiadecodigo.bootcamp8.duckhunt;
// Created by dgcst on 25/05/17

public interface MovableRepresentable {

    void move(int xSpeed, int ySpeed);

    int getOffsetX();

    int getOffsetY();

    void kill();

}
