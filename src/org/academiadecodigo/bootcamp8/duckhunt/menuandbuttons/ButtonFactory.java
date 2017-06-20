package org.academiadecodigo.bootcamp8.duckhunt.menuandbuttons;

/**
 * Created by prashanta on 20-06-2017.
 */
public class ButtonFactory {

    public static Button getNewButton(ButtonType type) {
        return new Button(type.getStartX(), type.getStartY(), type.getEndX(), type.getEndY());
    }
}
