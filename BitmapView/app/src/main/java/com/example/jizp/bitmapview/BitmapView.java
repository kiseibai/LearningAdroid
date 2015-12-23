package com.example.jizp.bitmapview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by jizp on 2015/12/14.
 */
public class BitmapView extends View{

    Paint paint=null;
    Resources src=null;
    Bitmap bmp=null;


    public BitmapView(Context context) {
        super(context);

        paint = new Paint();
        src =getResources();
        bmp = BitmapFactory.decodeResource(src, R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        String info = null;
        int posX=0;
        int posY=0;

        canvas.drawColor(Color.BLUE);
        canvas.drawBitmap(bmp,220,220,paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(60);
        info="X:"+bmp.getHeight()+";"+"Y:"+bmp.getWidth();
        posX = 135;
        posY = bmp.getWidth()+260;

        canvas.drawText(info,posX,posY,paint);


    }
}
