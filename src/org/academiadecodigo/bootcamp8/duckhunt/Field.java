package org.academiadecodigo.bootcamp8.duckhunt;

/**
 * Created by prashanta on 19-06-2017.
 */
public interface Field {

    void init();

    int getWidth();

    int getHeight();

    void welcomeMsg() throws InterruptedException;

    void scoreInit(Integer score);

    void drawScore();

    void updateScore(Integer newScore);

    void setNightMode();

    void restoreDayMode();

    void gameOver() throws InterruptedException;
}
