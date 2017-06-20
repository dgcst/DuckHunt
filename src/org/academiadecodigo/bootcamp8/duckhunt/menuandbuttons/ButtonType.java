package org.academiadecodigo.bootcamp8.duckhunt.menuandbuttons;

/**
 * Created by prashanta on 20-06-2017.
 */
public enum ButtonType {
    PLAY(453, 518, 747, 589),
    INSTRUCTIONS(272, 605, 927, 678),
    CREDITS(402, 701, 807, 768),
    BACK(70, 740, 290, 790),
    RELOAD(137, 697, 213, 780);

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    ButtonType(int startX, int startY, int endX, int endY) {
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
