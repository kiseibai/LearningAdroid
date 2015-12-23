package com.example.jizp.matixview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by jizp on 2015/12/14.
 */
public class MatixView extends View {

    Paint paint = null;
    Resources src = null;
    Bitmap bmp = null;


    public MatixView(Context context) {
        super(context);


        paint = new Paint();
        src = getResources();
        bmp = BitmapFactory.decodeResource(src, R.mipmap.ic_launcher);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bmp, 0, 800, paint);

        Matrix matrix = new Matrix();
        matrix.setScale(3f,3f);
        canvas.drawBitmap(bmp,matrix,paint);

    }
}
