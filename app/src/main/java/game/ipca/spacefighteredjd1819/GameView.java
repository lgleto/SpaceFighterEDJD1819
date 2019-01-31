package game.ipca.spacefighteredjd1819;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

public class GameView extends SurfaceView implements Runnable {

    volatile boolean playing;

    private Thread gameThread =  null;



    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private Player player;
    private List<Star> stars = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private Boom boom;

    public GameView(Context context, int width, int height) {
        super(context);

        player = new Player(context, BitmapFactory.decodeResource(context.getResources(), R.drawable.player), width,  height);

        surfaceHolder = getHolder();
        paint =  new Paint();

        for (int i = 0 ; i<100;i++){
            stars.add(new Star(width,height));
        }

        for (int i = 0 ; i<3;i++){
            enemies.add(new Enemy(context,width,height));
        }

        boom = new Boom(context);
    }

    @Override
    public void run() {
        while (playing){
            update();
            draw();
            control();
        }

    }


    int boomupdate = 0;

    private void update() {
        if (boomupdate>10) {
            boom.x = -250;
            boom.y = -250;
            boomupdate = 0;
        }
        boomupdate ++;
        player.update();
        for(Star s: stars){
            s.update(player.speed);
        }
        for(Enemy e: enemies){
            e.update(player.speed);
            if (Rect.intersects(player.detectCollision, e.detectCollision)){
                boom.x = e.x;
                boom.y = e.y;
                e.x=-200;

            }
        }
    }

    private void draw() {

        if(surfaceHolder.getSurface().isValid()){

            canvas = surfaceHolder.lockCanvas();

            canvas.drawColor(Color.BLACK);
            canvas.drawBitmap(player.bitmap,player.x,player.y,paint);
            paint.setColor(Color.WHITE);

            for(Star s: stars){
                paint.setStrokeWidth(s.getStartWidth());
                canvas.drawPoint(s.x,s.y,paint);
            }
            for(Enemy e: enemies){
                canvas.drawBitmap(e.bitmap,e.x,e.y,paint);
            }

            canvas.drawBitmap(boom.bitmap,boom.x,boom.y,paint);

            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void pause(){
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                player.boosting = false;
                break;
            case MotionEvent.ACTION_DOWN:
                player.boosting = true;
                break;
        }
        return true;
    }
}
