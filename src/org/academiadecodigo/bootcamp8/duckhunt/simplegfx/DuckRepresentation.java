package org.academiadecodigo.bootcamp8.duckhunt.simplegfx;

import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.duck.DuckType;
import org.academiadecodigo.bootcamp8.duckhunt.gameobjects.MovableRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DuckRepresentation implements MovableRepresentable {
    private Picture[] duckPics;
    private int imageOrder;


    public DuckRepresentation(DuckType type, int duckSpawn) {
        imageOrder = 0;
        duckPics = new Picture[3];
        duckPics[0] = new Picture(type.getxStart(), duckSpawn, type.getPic1());
        duckPics[1] = new Picture(type.getxStart(), duckSpawn, type.getPic2());
        duckPics[2] = new Picture(type.getxStart(), duckSpawn, type.getPic3());
    }

    @Override
    public int getOffsetX() {
        return duckPics[0].getWidth();
    }

    @Override
    public int getOffsetY() {
        return duckPics[0].getHeight();
    }

    @Override
    public void move(int xSpeed, int ySpeed) {
        duckPics[imageOrder].delete();
        imageOrder = imageOrder == duckPics.length - 1 ? 0 : ++imageOrder;
        duckPics[imageOrder].translate(xSpeed*duckPics.length, ySpeed);
        duckPics[imageOrder].draw();
    }

    @Override
    public void delete() {
        for (Picture p: duckPics) {
            p.delete();
        }
    }
}
