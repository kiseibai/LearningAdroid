package com.example.jizp.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.view.View;
import android.widget.GridView;

/**
 * Created by jizp on 2015/12/14.
 */
public class GraphicsView extends  View {

    Paint paint = null;

    public GraphicsView(Context context){
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);

        paint.setColor(Color.RED);
        canvas.drawRect(80, 20, 360, 180, paint);

        paint.setColor(Color.GREEN);
        canvas.drawCircle(220,100,60,paint);
    }



}
