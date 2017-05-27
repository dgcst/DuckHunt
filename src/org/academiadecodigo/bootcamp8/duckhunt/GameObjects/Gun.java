package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

// Created by dgcst on 25/05/17

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Gun extends GameObjects {

    private int bullets;
    private GunController gunController;

    public Gun() {
        gunController = new GunController();
        bullets = 100;
    }

    public void shoot() {
        bullets--;
    }

    private class GunController implements MouseHandler {

        private Mouse mouse;
        private MouseEvent currEvent;

        public GunController() {
            this.mouse = new Mouse(this);
            this.currEvent = currEvent;
            addEventListener();
        }

        public MouseEvent getCurrEvent() {
            return currEvent;
        }

        public void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
            mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            shoot();
            System.out.println(bullets);
            e.setX(e.getX()-8);
            e.setY(e.getY()-28);

            System.out.println(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            e.setX(e.getX()-8);
            e.setY(e.getY()-28);

            System.out.println(e);
        }
    }

}
