package org.academiadecodigo.bootcamp8.duckhunt.menuandbuttons;

/**
 * Created by prashanta on 20-06-2017.
 */
public class Button {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Button(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}
