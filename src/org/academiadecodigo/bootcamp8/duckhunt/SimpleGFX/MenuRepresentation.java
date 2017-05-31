package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.bootcamp8.duckhunt.Sound.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuRepresentation implements Representable {

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
        menu = new Sound("/resources/sounds/menu_music.wav");
    }

    @Override
    public void init() throws InterruptedException {
        menuLoading.draw();
        Thread.sleep(500);
        loading.play(true);
        Thread.sleep(5800);
        menuLoading.delete();
    }

    public void mainMenu() {
        menuBackground.draw();
    }

    public void stopMenuSound() {
        menu.stop();
    }

    public void menuSound() {
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


