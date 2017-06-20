package org.academiadecodigo.bootcamp8.duckhunt.simplegfx;

import org.academiadecodigo.bootcamp8.duckhunt.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldRepresentation implements Field {
    private static int fieldWidth;
    private static int fieldHeight;
    private Picture background;
    private Picture nightMode;
    private Picture overlay;
    private Text displayScore;
    private boolean nightModeOn;

    public FieldRepresentation() {
        background = new Picture(0,0, "resources/images/game/background/background-up-clouds.png");
        nightMode = new Picture(0, 0, "resources/images/game/background/background-up-night.png");
        overlay = new Picture(0, 0, "resources/images/game/overlay.png");
        fieldWidth = background.getWidth();
        fieldHeight = background.getHeight();
    }

    @Override
    public void init() throws InterruptedException {
        background.draw();
        welcomeMsg();
        overlay.draw();
    }


    @Override
    public void setNightMode() {
        if (!nightModeOn) {
            nightModeOn = true;
            nightMode.draw();
        }
    }

    @Override
    public void restoreDayMode(){
        if (nightModeOn) {
            nightModeOn = false;
            nightMode.delete();
        }
    }

    public static int getFieldWidth(){
        return fieldWidth;
    }

    public static int getFieldHeight() {
        return fieldHeight;
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }


    private void welcomeMsg() throws InterruptedException {
        Picture ready = new Picture(0,0, "resources/images/game/intro/ready.png");
        Picture set = new Picture(0,0, "resources/images/game/intro/set.png");
        Picture go = new Picture(0,0, "resources/images/game/intro/go.png");
        ready.draw();
        Thread.sleep(2000);
        set.draw();
        ready.delete();
        Thread.sleep(1500);
        go.draw();
        set.delete();
        Thread.sleep(800);
        go.delete();
    }

    @Override
    public void gameOver() throws InterruptedException {
        Picture gameOver = new Picture(0, 0, "resources/images/menu/gameover.png");
        gameOver.draw();
        Thread.sleep(2000);
    }

    @Override
    public void scoreInit(Integer score) {
        displayScore = new Text(964, 736, score.toString());
        displayScore.setColor(Color.WHITE);
        displayScore.grow(13, 13);
    }

    @Override
    public void drawScore(){
        displayScore.draw();
    }

    @Override
    public void updateScore(Integer newScore){
        displayScore.setText(newScore.toString());
    }
}
