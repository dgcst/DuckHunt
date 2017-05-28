package org.academiadecodigo.bootcamp8.duckhunt;

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.MenuRepresentation;
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
    private MenuRepresentation instructions;
    private int instructionsButtonX;
    private int instructionsButtonY;
    private int instructionsButtonXOffset;
    private int instructionsButtonYOffset;
    private MenuRepresentation credits;
    private int creditsButtonX;
    private int creditsButtonY;
    private int creditsButtonXOffset;
    private int creditsButtonYOffset;
    private boolean specialScreen;
    private boolean menuSelection;
    private boolean clicked;

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

    public int menuSelection() throws InterruptedException {
        while (!menuSelection) {
            Thread.sleep(100);

            //ARRUMAR O MENU

            if (specialScreen && clicked == false) {
                System.out.println("teste");
                specialScreen = false;
                return 0;
            }
            if ((getX() >= playButtonX && getX() <= playButtonXOffset) &&
                    (getY() >= playButtonY && getY() <= playButtonYOffset)) {
                menuSelection = true;
                return 1;
            }
            if ((getX() >= instructionsButtonX && getX() <= instructionsButtonXOffset) &&
                    (getY() >= instructionsButtonY && getY() <= instructionsButtonYOffset)) {
                clicked = false;
                specialScreen = true;
                return 2;
            }
            if ((getX() >= creditsButtonX && getX() <= creditsButtonXOffset) &&
                    (getY() >= creditsButtonY && getY() <= creditsButtonYOffset)) {
                clicked = false;
                specialScreen = true;
                return 3;
            }
        }
        return 4;
    }

    public void mainMenu() {
        menuRepresentation.mainMenu();
    }

    public void instructions() {
        instructions = new MenuRepresentation();
        instructions.instructions();
    }

    public void credits() {
        credits = new MenuRepresentation();
        credits.credits();
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



