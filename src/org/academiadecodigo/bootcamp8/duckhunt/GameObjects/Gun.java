package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

// Created by dgcst on 25/05/17

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Gun extends GameObjects {

    private int bullets;
    private GunController gunController;
    private int x;
    private int y;

    public Gun() {
        gunController = new GunController();
        bullets = 100;
    }

    /*
    // BULLETS LOGIC

    private Picture [] pic1;
    private int picNumber;
    private int maxBullets = 10;
    private int bulletRemove = maxBullets-1;

    //*****************************************************************
       for (int picNumber=0; picNumber<=maxBullets; picNumber++){
        pic1[picNumber] = new Picture(20+(40*picNumber), 500, "images/bullet.png");
        pic1[picNumber].grow(-150, -220);
        pic1[picNumber].draw();
    }
    //*****************************************************************


    //*****************************************************************
    @Override
    public void mouseClicked(MouseEvent e) {
        pic1[bulletRemove].delete();
        System.out.println(e);
        bulletRemove--;
    }
    //*****************************************************************

*/



    public void shoot() {
        bullets--;
    }

    public int getX() {
        return x;
    }
    public void resetX(){ x = -1;}

    public int getY() {
        return y;
    }
    public void resetY(){ y = -1;}

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
