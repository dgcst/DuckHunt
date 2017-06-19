package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.Special;
import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.duck.DuckType;
import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.GameObjectsFactory;
import org.academiadecodigo.bootcamp8.duckhunt.simplegfx.FieldRepresentation;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {
    private Duck[] ducks;
    private Special special;
    private Gun gun;
    private Field field;
    private Integer gameScore;
    private int gameLevel;
    private boolean exit;

    public Game() {
        new Controller();
    }

    public void menu() throws InterruptedException {
        exit = false;
        Menu menu = new Menu();
        menu.menuSelection();
        init();

    }

    public void init() throws InterruptedException {
        field = new FieldRepresentation();
        field.init();
        gameScore = 0;
        gameLevel = 1;
        ducks = new Duck[4];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = GameObjectsFactory.getNewDuck();
        }
        field.scoreInit(gameScore);
        gun = new Gun();
        start();

    }

    public void start() throws InterruptedException {
        gun.enableGun();
        while (!exit) {

            gun.reset();
            field.updateScore(gameScore);
            Thread.sleep(110);

            moveAllDucks();
            if (special != null) {
                specialsMove();
            }

            nightMode();
            level();
            field.drawScore();
        }
        gun.silenceGun();
        menu();
    }

    public void moveAllDucks() throws InterruptedException {
        for (int i = 0; i < ducks.length; i++) {
            if (ducks[i].getXOffSet() + ducks[i].getXSpeed() >= field.getWidth() ||
                    ducks[i].getXOffSet() < 0) {
                ducks[i].kill();
                ducks[i] = GameObjectsFactory.getNewDuck();
                return;
            }

            if (gun.isLoaded() && gun.getX() >= ducks[i].getX() && gun.getX() <= ducks[i].getXOffSet()
                    && gun.getY() >= ducks[i].getY() && gun.getY() <= ducks[i].getYOffSet()) {
                if (ducks[i].getType() == DuckType.REVRUBBER) {
                    gameOver();
                }
                ducks[i].kill();
                gameScore += ducks[i].getKillPoints();
                ducks[i] = GameObjectsFactory.getNewDuck();
                gun.reset();
                return;
            }

            if (!ducks[i].isDead()) {
                ducks[i].move();
            }
        }
    }

    public void specialsMove() {
        if (special.getXOffSet() + special.getXSpeed() >= field.getWidth() || special.getY() <= 0) {
            special.kill();
            special = null;
            return;
        }
        if (!special.isDead()) {
            special.move();
        }
    }


    public void level() {
        int levelUp = 1500;
        if (gameScore > levelUp * gameLevel) {
            gameLevel++;
            if (gameLevel % 5 != 0) {
                special = GameObjectsFactory.getNewSpecialObject();
            }
        }
    }

    public void nightMode() {
        if (gameLevel % 5 == 0) {
            field.setNightMode();
        } else {
            field.restoreDayMode();
        }
    }

    public void gameOver() throws InterruptedException {
        field.gameOver();
        exit = true;
    }

    private class Controller implements KeyboardHandler {
        private Keyboard key;
        private KeyboardEvent[] escKey;

        public Controller(){
            key = new Keyboard(this);
            escKey = new KeyboardEvent[2];
            createEvent();
            setEvents();
            addEventListener();
        }

        public void createEvent() {
            for (int i = 0; i < escKey.length; i++) {
                escKey[i] = new KeyboardEvent();
            }
        }

        public void setEvents() {
            escKey[0].setKey(KeyboardEvent.KEY_ESC);
            escKey[0].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            escKey[1].setKey(KeyboardEvent.KEY_ESC);
            escKey[1].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        }

        public void addEventListener() {
            for (KeyboardEvent event : escKey) {
                key.addEventListener(event);
            }
        }

        @Override
        public void keyPressed(KeyboardEvent e) {
            exit = true;
        }

        @Override
        public void keyReleased(KeyboardEvent e) {
        }
    }
}

