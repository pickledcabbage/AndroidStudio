package com.example.dima.messingaround;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Dima on 12/21/2015.
 */
public class Character {
    private Bitmap image;
    private int x, y;
    private final int DX = -10;
    public Character(Bitmap res)
    {
        image = res;
    }
    public void update(){
        x+=DX;
        if (x<-34)
        {
            y = (int)(Math.random()*(GamePanel.HEIGHT-81));
            x = GamePanel.WIDTH;
        }
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image,x,y,null);
    }
}
