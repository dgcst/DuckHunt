package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldRepresentation implements Representable {
    private static int fieldWidth;
    private Picture background;
    private Picture nightMode;
    private Text displayScore;
    private boolean nightModeOn;

    @Override
    public void init() {
        background = new Picture(0,0, "images/background-up-clouds.png");
        nightMode = new Picture(0, 0, "images/background-up-night.png");
        fieldWidth = background.getWidth();
        background.draw();
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

    public int getWidth() {
        return background.getWidth();
    }

    public int getHeight() {
        return background.getHeight();
    }

    public void welcomeMsg() throws InterruptedException {
        Text text = new Text(580, 100, "Welcome to the VEGAN Duck Hunt");
        text.setColor(Color.BLACK);
        text.grow(400, 70);
        text.draw();
        Thread.sleep(3000);
        text.delete();
        Text text1 = new Text(600, 200, "Get Ready...");
        text1.setColor(Color.BLACK);
        text1.grow(200, 50);
        text1.draw();
        Thread.sleep(2000);
        text1.delete();
        Text text2 = new Text(600, 300, "GO!");
        text2.setColor(Color.BLACK);
        text2.grow(100, 25);
        text2.draw();
        Thread.sleep(1000);
        text2.delete();
    }

    public void scoreInit(Integer score) {
        displayScore = new Text(120, 750, "Score: " + score.toString());
        displayScore.setColor(Color.BLACK);
        displayScore.grow(80, 20);
    }

    public void drawScore(){
        displayScore.draw();
    }

    public void updateScore(Integer newScore){
        displayScore.setText("Score: " + newScore.toString());

    }
}
