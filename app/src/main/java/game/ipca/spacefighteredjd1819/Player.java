package game.ipca.spacefighteredjd1819;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Player {

    Bitmap bitmap;

    int x;
    int y;
    int speed = 0;
    boolean boosting = false;
    private final int GRAVITY = -10;

    private int maxY;
    private int minY;

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    Rect detectCollision;

    public Player (Context context, int width, int height){
        x = 75;
        y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
        maxY = height - bitmap.getHeight();
        minY = 0;
        detectCollision = new Rect(x,y,bitmap.getWidth(),bitmap.getHeight());
    }

    public void update(){

        if (boosting)   speed += 2;
        else            speed -= 5;
        if (speed>MAX_SPEED) speed = MAX_SPEED;
        if (speed<MIN_SPEED) speed = MIN_SPEED;

        y -= speed + GRAVITY;

        if (y<minY) y=minY;
        if (y>maxY) y=maxY;

        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom =y+ bitmap.getHeight();
    }

}
