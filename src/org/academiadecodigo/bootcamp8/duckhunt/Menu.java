package org.academiadecodigo.bootcamp8.duckhunt;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.MenuRepresentation;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
    private int instructionsButtonX;
    private int instructionsButtonY;
    private int instructionsButtonXOffset;
    private int instructionsButtonYOffset;
    private int creditsButtonX;
    private int creditsButtonY;
    private int creditsButtonXOffset;
    private int creditsButtonYOffset;
    private int backButtonX;
    private int backButtonY;
    private int backButtonXOffset;
    private int backButtonYOffset;
    private boolean specialScreen;
    private boolean menuSelection;

    public Menu() throws InterruptedException {
        menuMouse = new MenuMouse();
        menuRepresentation = new MenuRepresentation();
        menuRepresentation.init();
        playButtonX = 453;
        playButtonXOffset = 747;
        playButtonY = 518;
        playButtonYOffset = 589;
        instructionsButtonX = 272;
        instructionsButtonY = 605;
        instructionsButtonXOffset = 927;
        instructionsButtonYOffset = 678;
        creditsButtonX = 402;
        creditsButtonY = 701;
        creditsButtonXOffset = 807;
        creditsButtonYOffset = 768;
        backButtonX = 20;
        backButtonY = 720;
        backButtonXOffset = 100;
        backButtonYOffset = 900;
        menuSelection = false;
        specialScreen = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMenuSelection() {
        return menuSelection;
    }

    public void menuSelection() throws InterruptedException {

        while (!menuSelection) {
            Thread.sleep(1);
            if (specialScreen) {
                if ((getX() >= backButtonX && getX() <= backButtonXOffset) &&
                        (getY() >= backButtonY && getY() <= backButtonYOffset)) {
                    menuRepresentation.creditsDelete();
                    menuRepresentation.instructionsDelete();
                    Thread.sleep(200);
                    specialScreen = false;
                    mainMenu();
                }
            }
            if ((getX() >= playButtonX && getX() <= playButtonXOffset) &&
                    (getY() >= playButtonY && getY() <= playButtonYOffset)) {
                menuSelection = true;
            }
            if ((getX() >= instructionsButtonX && getX() <= instructionsButtonXOffset) &&
                    (getY() >= instructionsButtonY && getY() <= instructionsButtonYOffset)) {
                specialScreen = true;
                instructions();

            }
            if ((getX() >= creditsButtonX && getX() <= creditsButtonXOffset) &&
                    (getY() >= creditsButtonY && getY() <= creditsButtonYOffset)) {
                specialScreen = true;
                credits();
            }
        }
    }

    public void mainMenu() {
        menuRepresentation.mainMenu();
    }

    public void instructions() {
        menuRepresentation.instructions();
    }

    public void credits() {
        menuRepresentation.credits();
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



