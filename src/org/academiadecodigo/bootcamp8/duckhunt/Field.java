package org.academiadecodigo.bootcamp8.duckhunt;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.FieldRepresentation;

public class Field {

    private FieldRepresentation background;
    private int width;
    private int heigth;

    public Field() throws InterruptedException {
        background = new FieldRepresentation();
        welcomeMsg();
        background.init();
        this.width = background.getWidth();
        this.heigth = background.getHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void welcomeMsg() throws InterruptedException {
        background.welcomeMsg();
    }

    public void scoreInit(Integer score){
        background.scoreInit(score);
    }

    public void drawScore(){
        background.drawScore();
    }

    public void updateScore(Integer newScore){
        background.updateScore(newScore);
    }

    public void setNightMode(){
        background.setNightMode();
    }

    public void restoreDayMode(){
        background.dayMode();
    }
}
