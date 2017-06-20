package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.menuandbuttons.Button;
import org.academiadecodigo.bootcamp8.duckhunt.menuandbuttons.ButtonFactory;
import org.academiadecodigo.bootcamp8.duckhunt.menuandbuttons.ButtonType;
import org.academiadecodigo.bootcamp8.duckhunt.simplegfx.BulletsRepresentation;
import org.academiadecodigo.bootcamp8.duckhunt.sound.Sound;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Gun {
    private BulletsRepresentation bulletPic;
    private static final int maxBullets = 12;
    private int currBullets;
    private int x;
    private int y;
    private Button reloadButton;
    private Sound sound;
    private Sound reload;
    private boolean isSilent;

    public Gun() {
        new GunController();
        reloadButton = ButtonFactory.getNewButton(ButtonType.RELOAD);
        bulletPic = new BulletsRepresentation(maxBullets);
        currBullets = maxBullets;
        sound = new Sound ("/resources/sounds/gun3.wav");
        reload = new Sound ("/resources/sounds/reload.wav");
    }

    public void silenceGun(){
        isSilent = true;
    }

    public void enableGun(){
        isSilent = false;
    }

    private void shoot() {
        if (isSilent){
            return;
        }

        if ((x >= reloadButton.getStartX() && x <= reloadButton.getEndX()
                && y >= reloadButton.getStartY() && y <= reloadButton.getEndY()
                && currBullets != maxBullets)) {
            reload.play(true);
            bulletPic.drawBullets();
            currBullets = maxBullets;
            return;
        }
        if(currBullets > 0){
            bulletPic.shoot();
            sound.play(true);
            currBullets--;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reset(){ x = -1; y = -1;}


    public boolean isLoaded() {
        return currBullets > 0;
    }

    
    private class GunController implements MouseHandler {
        private Mouse mouse;

        GunController() {
            this.mouse = new Mouse(this);
            addEventListener();
        }

        void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            x = (int) e.getX();
            y = (int) e.getY();
            shoot();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

}
