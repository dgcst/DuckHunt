package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
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
    private Rectangle reloadButton;


    public BulletsRepresentation(int maxBullets){
        this.maxBullets = maxBullets;
        init();
    }

    @Override
    public void init(){
        reloadButton = new Rectangle(1000, 710, 160, 70);
        reloadButton.setColor(Color.ORANGE);
        reloadButton.fill();

        Text text = new Text(1060, 740, "RELOAD");
        text.setColor(Color.BLACK);
        text.grow(30, 25);
        text.draw();

        drawBullets();
    }

    public void drawBullets() {
        pic1 = new Picture[maxBullets];
        for (int i = currBulletIndex; i < maxBullets; i++) {
            pic1[i] = new Picture(200 + (40 * i), 500, "images/bullet.png");
            pic1[i].grow(-150, -220);
            pic1[i].draw();
        }
        currBulletIndex = maxBullets - 1;
    }

    public void shoot(){
        pic1[currBulletIndex].delete();
        currBulletIndex--;
    }

    //+8 value to offset small mouse discrepancy found in SimpleGFX in X position
    public int getXReload(){
        return reloadButton.getX() + 8;
    }

    //+28 value to offset small mouse discrepancy in Y position
    public int getYReload(){
        return reloadButton.getY() + 28;
    }

    public int getXOffSetReload(){
        return reloadButton.getWidth() + getXReload();
    }

    public int getYOffSetReload(){
        return reloadButton.getHeight() + getYReload();
    }
}
