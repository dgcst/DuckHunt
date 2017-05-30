package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuRepresentation implements Representable {

    private Picture menuBackground;
    private Picture menuLoading;
    private Picture instructions;
    private Picture credits;

    public MenuRepresentation() {
        this.menuBackground = new Picture(0, 0, "resources/images/menu/menuButtons.png");
        this.menuLoading = new Picture(0,0, "resources/images/menu/loading.png");
        this.instructions = new Picture(0,0, "resources/images/menu/instructions.png");
        this.credits = new Picture(0,0, "resources/images/menu/credits.png");
    }

    @Override
    public void init() throws InterruptedException {
        menuLoading.draw();
        Thread.sleep(1000);
        menuLoading.delete();
        mainMenu();
    }

    public  void mainMenu() {
        menuBackground.draw();
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


