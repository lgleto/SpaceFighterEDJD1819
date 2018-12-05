package game.ipca.spacefighteredjd1819;

import java.util.Random;

public class Star {

    int x;
    int y;
    int speed = 0;
    private int maxY;
    private int minY;
    private int maxX;
    private int minX;

    public Star (int width, int height){
        maxY = height;
        minY = 0;
        maxX = width;
        minX = 0;

        Random generator = new Random();
        speed = generator.nextInt(10);
        x = generator.nextInt(maxX);;
        y = generator.nextInt(maxY);
    }

    public void update(int playerSpeed){

        x -= playerSpeed;
        x -= speed;

        if (x<0){
            x=maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = generator.nextInt(10);
        }
    }

    public float getStartWidth(){
        Random generator = new Random();
        float w = (float)(generator.nextFloat()*8.0 + 1.0);
        return w;
    }
}
