package org.academiadecodigo.bootcamp8.duckhunt;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.MenuRepresentation;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

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
        loading();
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

    public int getPlayButtonX() {
        return playButtonX;
    }

    public int getPlayButtonY() {
        return playButtonY;
    }

    public int getPlayButtonXOffset() {
        return playButtonXOffset;
    }

    public int getPlayButtonYOffset() {
        return playButtonYOffset;
    }

    public int getInstructionsButtonX() {
        return instructionsButtonX;
    }

    public int getInstructionsButtonY() {
        return instructionsButtonY;
    }

    public int getInstructionsButtonXOffset() {
        return instructionsButtonXOffset;
    }

    public int getInstructionsButtonYOffset() {
        return instructionsButtonYOffset;
    }

    public int getCreditsButtonX() {
        return creditsButtonX;
    }

    public int getCreditsButtonY() {
        return creditsButtonY;
    }

    public int getCreditsButtonXOffset() {
        return creditsButtonXOffset;
    }

    public int getCreditsButtonYOffset() {
        return creditsButtonYOffset;
    }

    public int getBackButtonX() {
        return backButtonX;
    }

    public int getBackButtonY() {
        return backButtonY;
    }

    public int getBackButtonXOffset() {
        return backButtonXOffset;
    }

    public int getBackButtonYOffset() {
        return backButtonYOffset;
    }

    public boolean isMenuSelection() {
        return menuSelection;
    }

    public void menuSelection() throws InterruptedException {

        while (!menuSelection) {
            Thread.sleep(1);
            if (specialScreen) {
                if ((getX() >= getBackButtonX() && getX() <= getBackButtonXOffset()) &&
                        (getY() >= getBackButtonY() && getY() <= getBackButtonYOffset())) {
                    menuRepresentation.creditsDelete();
                    menuRepresentation.instructionsDelete();
                    Thread.sleep(200);
                    specialScreen = false;
                    mainMenu();
                }
            }
            if ((getX() >= getPlayButtonX() && getX() <= getPlayButtonXOffset()) &&
                    (getY() >= getPlayButtonY() && getY() <= getPlayButtonYOffset())) {
                menuRepresentation.stopMenuSound();
                menuSelection = true;
            }
            if ((getX() >= getInstructionsButtonX() && getX() <= getInstructionsButtonXOffset()) &&
                    (getY() >= getInstructionsButtonY() && getY() <= getInstructionsButtonYOffset())) {
                specialScreen = true;
                instructions();

            }
            if ((getX() >= getCreditsButtonX() && getX() <= getCreditsButtonXOffset()) &&
                    (getY() >= getCreditsButtonY() && getY() <= getCreditsButtonYOffset())) {
                specialScreen = true;
                credits();
            }
        }
    }

    public void loading() throws InterruptedException {
        menuRepresentation.init();
        mainMenu();
    }

    public void mainMenu() {
        menuRepresentation.menuSound();
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
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}



