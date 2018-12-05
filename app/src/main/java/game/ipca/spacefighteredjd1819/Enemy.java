package game.ipca.spacefighteredjd1819;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Enemy {

    int x;
    int y;
    int speed = 0;
    private int maxY;
    private int minY;
    private int maxX;
    private int minX;

    Bitmap bitmap;

    Rect detectCollision;

    public Enemy (Context context, int width, int height){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);

        maxY = height;
        minY = 0;
        maxX = width;
        minX = 0;

        Random generator = new Random();
        speed = generator.nextInt(6) + 10;
        x = width;
        y = generator.nextInt(maxY)-bitmap.getHeight();

        detectCollision = new Rect(x,y,bitmap.getWidth(),bitmap.getHeight());

    }

    public void update(int playerSpeed){

        x -= playerSpeed;
        x -= speed;

        if (x<minX - bitmap.getWidth()){
            x=maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY)-bitmap.getHeight();
            speed = generator.nextInt(6)+10;
        }
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom =y+ bitmap.getHeight();

    }



}
