package org.academiadecodigo.bootcamp8.duckhunt.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by prashanta on 28-05-2017.
 */
public class BulletsRepresentation {
    private Picture[] pic1;
    private int maxBullets;
    private int currBulletIndex;


    public BulletsRepresentation(int maxBullets){
        this.maxBullets = maxBullets;
        pic1 = new Picture[this.maxBullets];
        drawBullets();
    }

    public void drawBullets() {
        for (int i = currBulletIndex; i < maxBullets; i++) {
            pic1[i] = new Picture(226 + (38 * i), FieldRepresentation.getFieldHeight() - 92,
                    "resources/images/game/bullet.png");
            pic1[i].draw();
        }
        currBulletIndex = maxBullets - 1;
    }

    public void shoot(){
        pic1[currBulletIndex].delete();
        if (currBulletIndex > 0){
            currBulletIndex--;
        }
    }
}
