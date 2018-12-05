package game.ipca.spacefighteredjd1819;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Boom {

    int x;
    int y;
    Bitmap bitmap;

    public Boom (Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.boom);
        x = -250;
        y = -250;
    }
}
