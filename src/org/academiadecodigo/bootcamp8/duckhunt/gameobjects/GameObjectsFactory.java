package org.academiadecodigo.bootcamp8.duckhunt.gameobjects;
// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.duck.Duck;
import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.duck.DuckType;

public class GameObjectsFactory {
    private static final double CHANCE_FACTOR = 0.7;

    public static Duck getNewDuck() {
        int random = (int) (Math.random() * DuckType.values().length);
        DuckType duckType = DuckType.values()[random];
        switch (duckType) {
            case SPECIAL:
                return chanceSpecial(duckType);
            case REVSPECIAL:
                return chanceRevSpecial(duckType);
            default:
                return new Duck(duckType);
        }
    }

    private static Duck chanceSpecial(DuckType duckType) {
        if (Math.random() * 1 > CHANCE_FACTOR) {
            return new Duck(duckType);
        }
        return new Duck(DuckType.NORMAL);
    }

    private static Duck chanceRevSpecial(DuckType duckType) {
        if (Math.random() * 1 > CHANCE_FACTOR) {
            return new Duck(duckType);
        }
        return new Duck(DuckType.REVNORMAL);
    }

    public static Special getNewSpecialObject(){
        int random = (int) (Math.random() * SpecialsType.values().length);
        SpecialsType specialType = SpecialsType.values()[random];

        return new Special(specialType);
    }
}
