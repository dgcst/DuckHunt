package org.academiadecodigo.bootcamp8.duckhunt.simplegfx;

import org.academiadecodigo.bootcamp8.duckhunt.sound.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuRepresentation {

    private Picture menuBackground;
    private Picture menuLoading;
    private Picture instructions;
    private Picture credits;
    private Sound loading;
    private Sound menu;

    public MenuRepresentation() {
        this.menuBackground = new Picture(0, 0, "resources/images/menu/menuButtons.png");
        this.menuLoading = new Picture(0,0, "resources/images/menu/loading.png");
        this.instructions = new Picture(0,0, "resources/images/menu/instructions.png");
        this.credits = new Picture(0,0, "resources/images/menu/credits.png");
        loading = new Sound("/resources/sounds/boot.wav");

    }

    public void init() throws InterruptedException {
        menuLoading.draw();
        Thread.sleep(600);
        loading.play(true);
        Thread.sleep(5500);
        menuLoading.delete();
    }

    public void mainMenu() {
        menuBackground.draw();
    }

    public void stopMenuSound() {
        menu.stop();
    }

    public void menuSound() {
        menu = new Sound("/resources/sounds/menu_music.wav");
        menu.setLoop(10);
        menu.play(true);
    }

    public void instructions() {
        instructions.draw();
    }

    public void credits() {
        credits.draw();
    }

    public void creditsDelete() {
        credits.delete();
    }

    public void instructionsDelete() {
        instructions.delete();
    }
}


