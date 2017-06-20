package org.academiadecodigo.bootcamp8.duckhunt.menuandbuttons;

import org.academiadecodigo.bootcamp8.duckhunt.simplegfx.MenuRepresentation;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Menu {

    private MenuRepresentation menuRepresentation;
    private int mouseX;
    private int mouseY;
    private Button play;
    private Button instructions;
    private Button credits;
    private Button back;
    private boolean specialScreen;
    private boolean menuSelection;

    public Menu() throws InterruptedException {
        new MenuMouse();
        menuRepresentation = new MenuRepresentation();
        loading();
        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        instructions = ButtonFactory.getNewButton(ButtonType.INSTRUCTIONS);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        back = ButtonFactory.getNewButton(ButtonType.BACK);
        menuSelection = false;
        specialScreen = false;
    }

    private int getMouseX() {
        return mouseX;
    }

    private int getMouseY() {
        return mouseY;
    }

    public void menuSelection() throws InterruptedException {

        while (!menuSelection) {
            Thread.sleep(1);
            if (specialScreen) {
                if ((getMouseX() >= back.getStartX() && getMouseX() <= back.getEndX()) &&
                        (getMouseY() >= back.getStartY() && getMouseY() <= back.getEndY())) {
                    menuRepresentation.creditsDelete();
                    menuRepresentation.instructionsDelete();
                    Thread.sleep(200);
                    specialScreen = false;
                    mainMenu();
                }
            }
            if ((getMouseX() >= play.getStartX() && getMouseX() <= play.getEndX()) &&
                    (getMouseY() >= play.getStartY() && getMouseY() <= play.getEndY())) {
                menuRepresentation.stopMenuSound();
                menuSelection = true;
            }
            if ((getMouseX() >= instructions.getStartX() && getMouseX() <= instructions.getEndX()) &&
                    (getMouseY() >= instructions.getStartY() && getMouseY() <= instructions.getEndY())) {
                specialScreen = true;
                instructions();
            }
            if ((getMouseX() >= credits.getStartX() && getMouseX() <= credits.getEndX()) &&
                    (getMouseY() >= credits.getStartY() && getMouseY() <= credits.getEndY())) {
                specialScreen = true;
                credits();
            }
        }
    }

    private void loading() throws InterruptedException {
        menuRepresentation.init();
        menuRepresentation.menuSound();
        mainMenu();
    }

    private void mainMenu() {
        menuRepresentation.mainMenu();
    }

    private void instructions() {
        menuRepresentation.instructions();
    }

    private void credits() {
        menuRepresentation.credits();
    }


    private class MenuMouse implements MouseHandler {
        private Mouse mouse;

        MenuMouse() {
            this.mouse = new Mouse(this);
            addEventListener();
        }

        void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            mouseX = (int) e.getX();
            mouseY = (int) e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}



