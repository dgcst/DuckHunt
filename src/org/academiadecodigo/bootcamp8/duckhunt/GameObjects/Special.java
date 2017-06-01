package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.SpecialRepresentation;
import org.academiadecodigo.bootcamp8.duckhunt.Sound.Sound;

/**
 * Created by prashanta on 27-05-2017.
 */
public class Special extends GameObjects {
    private int xSpeed;
    private int ySpeed;
    private SpecialRepresentation specRep;
    private boolean dead;
    private int x;
    private int y;
    private int xOffSet;
    private int yOffSet;
    private Sound sound;

    public Special(SpecialsType type) {
        this.xSpeed = type.getxSpeed();
        this.ySpeed = type.getySpeed();
        this.x = type.getxStart();
        this.y = type.getyStart();
        this.specRep = new SpecialRepresentation(type);
        this.xOffSet = x + specRep.getOffsetX();
        this.yOffSet = y + specRep.getOffsetY();
        sound = new Sound(type.getSound());
    }


    public void move(){
        sound.play(false);
        if (!dead) {
            specRep.move(xSpeed, ySpeed);
            x += xSpeed;
            xOffSet += xSpeed;
            y += ySpeed;
            yOffSet += ySpeed;
        }
    }

    public void kill() {
        sound.stop();
        dead = true;
        specRep.kill();
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

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

}
