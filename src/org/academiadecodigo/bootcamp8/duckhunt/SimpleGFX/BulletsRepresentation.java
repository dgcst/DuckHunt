package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Field;
import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.bootcamp8.duckhunt.Sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by prashanta on 28-05-2017.
 */
public class BulletsRepresentation implements Representable{
    private Picture[] pic1;
    private int maxBullets;
    private int currBulletIndex;

    public BulletsRepresentation(int maxBullets){
        this.maxBullets = maxBullets;
        pic1 = new Picture[this.maxBullets];
        init();
    }

    @Override
    public void init(){
        drawBullets();
    }

    public void drawBullets() {
        for (int i = currBulletIndex; i < maxBullets; i++) {
            pic1[i] = new Picture(226 + (38 * i), FieldRepresentation.getFieldHeight() - 92, "resources/images/game/bullet.png");
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

    //+8 value to offset small mouse discrepancy found in SimpleGFX in X position
    public int getXReload(){
        return 137; //reloadButton.getX() + 8;
    }

    //+28 value to offset small mouse discrepancy in Y position
    public int getYReload(){
        return 697; //reloadButton.getY() + 28;
    }

    public int getXOffSetReload(){
        return 213;//reloadButton.getWidth() + getXReload();
    }

    public int getYOffSetReload(){
        return 780;//reloadButton.getHeight() + getYReload();
    }
}
