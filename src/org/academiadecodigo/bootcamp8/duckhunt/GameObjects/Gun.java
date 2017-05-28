package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

// Created by dgcst on 25/05/17

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Gun {

    private int bullets;
    private GunController gunController;
    private int x;
    private int y;
    private Picture[] pic1;
    private int maxBullets = 16;
    private int bulletRemove = maxBullets - 1;
    private Rectangle background2;
    private Ellipse reload;


    public void newBullet() {

        background2 = new Rectangle(310, 710, 650, 70);
        background2.setColor(Color.GRAY);
        background2.fill();

        Ellipse reload = new Ellipse(1000, 700, 160, 80);
        reload.setColor(Color.ORANGE);
        reload.fill();

        Text text = new Text(1060, 730, "RELOAD");
        text.setColor(Color.BLACK);
        text.grow(30, 25);
        text.draw();

        pic1 = new Picture[bullets];

        for (int picNumber = 0; picNumber < maxBullets; picNumber++) {
            pic1[picNumber] = new Picture(200 + (40 * picNumber), 500, "images/bullet.png");
            pic1[picNumber].grow(-150, -220);
            pic1[picNumber].draw();
        }
    }

    public Gun() {
        gunController = new GunController();
        bullets = maxBullets;
    }


    public void shoot() {
        bullets--;
    }

    public int getX() {
        return x;
    }

    public void resetX() {
        x = -1;
    }

    public int getY() {
        return y;
    }

    public void resetY() {
        y = -1;
    }

    private class GunController implements MouseHandler {

        private Mouse mouse;
        //private MouseEvent currEvent;

        public GunController() {
            this.mouse = new Mouse(this);
            //this.currEvent = currEvent;
            addEventListener();
        }

        /*public MouseEvent getCurrEvent() {
            return currEvent;
        }*/

        public void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            pic1[bulletRemove].delete();
            bulletRemove--;
            shoot();
            x = (int) e.getX();
            y = (int) e.getY();
            System.out.println("SHOOTING");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //e.setX(e.getX()-8);
            //e.setY(e.getY()-28);
            //System.out.println(e);
        }
    }

}
