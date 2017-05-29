package org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX;

import org.academiadecodigo.bootcamp8.duckhunt.Representable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuRepresentation implements Representable {

    private Picture menuBackground;
    private Picture menuLoading;
    private Picture instructions;
    private Picture credits;

    @Override
    public void init() throws InterruptedException {
        //menuLoading = new Picture(0,0, "images/menu/loading.png");
        //menuLoading.draw();
        //Thread.sleep(5000);
        //menuLoading.delete();
        mainMenu();
    }

    public  void mainMenu() {
        menuBackground = new Picture(0, 0, "images/menu/menuButtons.png");
        menuBackground.draw();
    }
    public void instructions() {
        instructions = new Picture(0,0, "images/menu/instructions.png");
        instructions.draw();
    }

    public void credits() {
        credits = new Picture(0,0, "images/menu/credits.png");
        credits.draw();
    }

    public void creditsDelete() {
        credits.delete();
    }

    public void instructionsDelete() {
        instructions.delete();
    }
}


