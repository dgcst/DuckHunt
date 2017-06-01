package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldRepresentation implements Representable {
    private static int fieldWidth;
    private static int fieldHeight;
    private Picture background;
    private Picture nightMode;
    private Picture overlay;
    private Text displayScore;
    private boolean nightModeOn;
    private Picture ready;
    private Picture set;
    private Picture go;

    @Override
    public void init() {
        background = new Picture(0,0, "resources/images/game/background/background-up-clouds.png");
        nightMode = new Picture(0, 0, "resources/images/game/background/background-up-night.png");
        overlay = new Picture(0, 0, "resources/images/game/overlay.png");
        fieldWidth = background.getWidth();
        fieldHeight = background.getHeight();
        background.draw();
        newOverlay();

    }

    public void newOverlay() {
        overlay.draw();
    }

    public void setNightMode(){
        nightModeOn = true;
        background.delete();
        nightMode.draw();
    }

    public void dayMode(){
        if (nightModeOn) {
            nightMode.delete();
            background.draw();
        }
    }

    public static int getFieldWidth(){
        return fieldWidth;
    }

    public static int getFieldHeight() {
        return fieldHeight;
    }

    public int getWidth() {
        return background.getWidth();
    }

    public int getHeight() {
        return background.getHeight();
    }

    public void welcomeMsg() throws InterruptedException {
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
    }

    public void scoreInit(Integer score) {
        displayScore = new Text(964, 735, score.toString());
        displayScore.setColor(Color.WHITE);
        displayScore.grow(13, 13);
    }

    public void drawScore(){
        displayScore.draw();
    }

    public void updateScore(Integer newScore){
        displayScore.setText(newScore.toString());

    }
}
