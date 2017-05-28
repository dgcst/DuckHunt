package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.UfoRepresentation;

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
    //public static int duckSpawn = 0;

    public Ufo() {

        this.speed = 40;
        //this.killPoints = type.getKillPoints();
        this.x = 0;
        this.y = 150;
        this.ufoRep= new UfoRepresentation(y, speed);
        this.xOffSet = x + ufoRep.getOffsetX();
        this.yOffSet = y + ufoRep.getOffsetY();

    }
    public void move(){
        if (!dead) {
            ufoRep.move(speed);
            x +=  speed;
            xOffSet += speed;
        }
    }

}
