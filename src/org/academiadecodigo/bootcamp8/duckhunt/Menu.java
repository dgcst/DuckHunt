package org.academiadecodigo.bootcamp8.duckhunt;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.MenuRepresentation;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import javax.sound.midi.SoundbankResource;

public class Menu extends Game {

    private MenuRepresentation menuRepresentation;
    private MenuMouse menuMouse;
    private int x;
    private int y;
    private int playButtonX;
    private int playButtonY;
    private int playButtonXOffset;
    private int playButtonYOffset;
    private boolean menuSelection;

    public Menu() {
        menuMouse = new MenuMouse();
        menuRepresentation = new MenuRepresentation();
        menuRepresentation.init();
        playButtonX = 453;
        playButtonXOffset = 747;
        playButtonY = 518;
        playButtonYOffset = 589;
        menuSelection = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int menuSelection() throws InterruptedException {
        while (!menuSelection) {
            Thread.sleep(100);
            if ((getX() >= playButtonX && getX() <= playButtonXOffset) &&
                    (getY() >= playButtonY && getY() <= playButtonYOffset)) {
                menuSelection = true;
                return 1;
            }
        }
        return 0;
    }

    private class MenuMouse implements MouseHandler {

        private Mouse mouse;

        public MenuMouse() {
            this.mouse = new Mouse(this);
            addEventListener();
        }

        public void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            x = (int) e.getX();
            y = (int) e.getY();
            System.out.println(x);
            System.out.println(y);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}

