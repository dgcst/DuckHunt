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
        }
        return new Duck(DuckType.NORMAL);
    }
}
