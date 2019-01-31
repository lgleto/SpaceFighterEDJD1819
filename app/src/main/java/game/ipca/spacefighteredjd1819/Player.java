package game.ipca.spacefighteredjd1819;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Player extends Sprite {

    int speed = 0;
    boolean boosting = false;
    private final int GRAVITY = -10;

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    public Player(Context context, Bitmap bitmap, int width, int height) {
        super(context, bitmap, width, height);
        x = 75;
        y = 50;
        speed = 1;
        this.bitmap = bitmap;
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
