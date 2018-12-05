package game.ipca.spacefighteredjd1819;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player {

    Bitmap bitmap;

    int x;
    int y;

    int speed = 0;

    public Player (Context context){
        x = 75;
        y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
    }

    public void upate(){
        x++;
    }

}
