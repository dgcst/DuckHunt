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
                if (Math.random() < 0.7){
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
                if (Math.random() < 0.7){
                    return new Duck(DuckType.REVNORMAL);
                } else {
                    return new Duck(DuckType.REVSPECIAL);
                }
            case REVRUBBER:
                return new Duck(DuckType.REVRUBBER);
        }
        return new Duck(DuckType.NORMAL);
    }


    public static GameObjects getNewSpecialObject(){
        int random = (int) (Math.random() * SpecialsType.values().length);
        SpecialsType specialType = SpecialsType.values()[random];

        switch (specialType) {
            case UFO:
                return new Special(SpecialsType.UFO);
            case CATARINA:
                return new Special(SpecialsType.CATARINA);
        }
        return new Special(SpecialsType.CATARINA);
    }
}
