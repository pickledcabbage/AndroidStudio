package com.example.dima.messingaround;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Dima on 12/15/2015.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{
    public static final int WIDTH = 468;
    public static final int HEIGHT = 314;
    private MainThread thread;
    private Background bg;
    private Character guy;

    public GamePanel(Context context)
    {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(),this);
        setFocusable(true);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}
    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try
            {
                thread.setRunning(false);
                thread.join();
            }
            catch(InterruptedException e){e.printStackTrace();}
            retry = false;
        }
    }
    @Override
    public void surfaceCreated (SurfaceHolder holder)
    {
        bg = new Background(BitmapFactory.decodeResource(getResources(),R.drawable.background));
        bg.setVector(0);
        guy = new Character(BitmapFactory.decodeResource(getResources(),R.drawable.guy));
        thread.setRunning(true);
        thread.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }
    public void update()
    {

        bg.update();
        guy.update();

    }
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/WIDTH;
        final float scaleFactorY = getHeight()/HEIGHT;
        if (canvas!=null)
        {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX,scaleFactorY);
            //canvas.drawRect(0,0,WIDTH,HEIGHT,null);
            bg.draw(canvas);
            guy.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}
