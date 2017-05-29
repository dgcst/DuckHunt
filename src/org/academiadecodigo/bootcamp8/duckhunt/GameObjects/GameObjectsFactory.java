package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;
// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.GameObjects.Duck.DuckType;

public class GameObjectsFactory {

    public static Duck getNewDuck() {
        int random = (int) (Math.random() * DuckType.values().length);
        DuckType duckType = DuckType.values()[random];
        switch (duckType) {
            case SLOW:
                return new Duck(DuckType.SLOW);
            case NORMAL:
                return new Duck(DuckType.NORMAL);
            case FAST:
                return new Duck(DuckType.FAST);
            case SPECIAL:
                if (Math.random() < 0.8){
                    return new Duck(DuckType.NORMAL);
                } else {
                    return new Duck(DuckType.SPECIAL);
                }
            case REVSLOW:
                return new Duck(DuckType.REVSLOW);
            case REVNORMAL:
                return new Duck(DuckType.REVNORMAL);
            case REVFAST:
                return new Duck(DuckType.REVFAST);
            case REVSPECIAL:
                if (Math.random() < 0.8){
                    return new Duck(DuckType.REVNORMAL);
                } else {
                    return new Duck(DuckType.REVSPECIAL);
                }
        }
        return new Duck(DuckType.NORMAL);
    }

    //Factory for other game objects not ducks with special features
    public static GameObjects getNewSpecialObject(){
        int random = (int) (Math.random() * GameObjectsType.values().length);
        GameObjectsType specialType = GameObjectsType.values()[random];

        switch (specialType) {
            case UFO:
                return new Ufo();
        }
        return new Ufo();
    }
}
