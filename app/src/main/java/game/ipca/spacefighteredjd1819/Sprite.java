package game.ipca.spacefighteredjd1819;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;

public class Sprite {

    Bitmap bitmap;

    int x;
    int y;

   protected int maxY;
   protected int maxX;
   protected int minY;
   protected int minX;

    Rect detectCollision;

    public Sprite (Context context, Bitmap bitmap, int width, int height){
        x = 0;
        y = 0;
        maxX = width;
        maxY = height;
        minX = 0;
        minY = 0;
        if (bitmap != null) {
            this.bitmap = bitmap;
            maxY = height - bitmap.getHeight();
            minY = height - bitmap.getHeight();
            detectCollision = new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void update(){}

}
