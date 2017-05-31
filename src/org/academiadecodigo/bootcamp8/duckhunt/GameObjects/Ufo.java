package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.UfoRepresentation;
import org.academiadecodigo.bootcamp8.duckhunt.Sound.Sound;

/**
 * Created by prashanta on 27-05-2017.
 */
public class Ufo extends GameObjects {
    private int speed;
    private UfoRepresentation ufoRep;
    private boolean dead;
    private int x;
    private int y;
    private int xOffSet;
    private int yOffSet;
    private Sound sound;

    public Ufo() {
        this.speed = 30;
        this.x = 0;
        this.y = 600;
        this.ufoRep= new UfoRepresentation(y, speed);
        this.xOffSet = x + ufoRep.getOffsetX();
        this.yOffSet = y + ufoRep.getOffsetY();
        sound = new Sound ("/resources/sounds/ufo.wav");



    }
    public void move(){
        sound.play(false);
        if (!dead) {
            ufoRep.move(speed);
            x +=  speed;
            xOffSet += speed;
            y -= 25;
            yOffSet -= 25;
        }
    }

    public void kill() {
        sound.stop();
        dead = true;
        ufoRep.kill();
    }

    public boolean isDead() {
        return dead;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXOffSet() {
        return xOffSet;
    }

    public int getYOffSet() {
        return yOffSet;
    }

    public int getSpeed() {
        return speed;
    }

}
