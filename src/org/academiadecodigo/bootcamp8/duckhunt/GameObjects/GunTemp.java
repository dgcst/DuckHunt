package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

/**
 * Created by codecadet on 30/05/17.
 */
public class GunTemp {
package org.academiadecodigo.bootcamp8.duckhunt.GameObjects;

// Created by dgcst on 25/05/17

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

    public class Gun {

        private int bullets;
        private GunController gunController;
        private int x;
        private int y;
        private Picture[] pic1;
        private int maxBullets = 16;
        private int bulletRemove;
        private Rectangle reloadBack;
        private int xInit_Reload = 1000;
        private int yInit_Reload = 710;
        private int dxReload = 160;
        private int dyReload = 70;
        private boolean firstBullet = false;
        private boolean reload = true;
        private boolean enable = false;

        public void newBullet() {

            reloadBack = new Rectangle(xInit_Reload, yInit_Reload, dxReload, dyReload);
            reloadBack.setColor(Color.ORANGE);
            reloadBack.fill();

            Text text = new Text(1060, 740, "RELOAD");
            text.setColor(Color.BLACK);
            text.grow(30, 25);
            text.draw();

            newBullet1();
        }

        public void newBullet1() {


            pic1 = new Picture[maxBullets];

            if(!firstBullet || (bulletRemove<=0 && reload)){
                for (int picNumber = 0; picNumber < maxBullets; picNumber++) {
                    pic1[picNumber] = new Picture(200 + (40 * picNumber), 500, "images/bullet.png");
                    pic1[picNumber].grow(-150, -220);
                    pic1[picNumber].draw();
                    firstBullet = true;
                }
                bulletRemove = maxBullets -1;
            }
            enable = true;
        }

        public Gun() {
            gunController = new GunController();
            bullets = maxBullets;
        }


        public void shoot() {
            if(bulletRemove>=0){
                pic1[bulletRemove].delete();
                bulletRemove--;
            }

            System.out.println("x" + x + "y"+ y);
            if ((x >= xInit_Reload + 8 && x <= xInit_Reload + dxReload + 8) && y >= yInit_Reload+28 && y <= yInit_Reload +dyReload+28) {
                reload=true;
                newBullet1();
            }
        }

        public int getX() {
            return x;
        }
        public void resetX(){ x = -1;}

        public int getY() {
            return y;
        }
        public void resetY(){ y = -1;}

        private class GunController implements MouseHandler {
            private Mouse mouse;

            public GunController() {
                this.mouse = new Mouse(this);
                addEventListener();
            }

            public void addEventListener() {
                mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                x = (int) e.getX();
                y = (int) e.getY();

                if(enable){
                    shoot();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        }
    }
}
