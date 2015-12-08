package com.example.jizp.zoomcontrols;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ZoomControls;

public class MainActivity extends Activity {

    private LinearLayout linearLayout = null;
    private ZoomControls zoomControls = null;
    private ImageView imageView = null;
    private int id = 0;
    private int displayWidth = 0;
    private int displayHeight = 0;
    private float scaleWidth = 1;
    private float scaleHeight = 1;
    private Bitmap bitmap = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        zoomControls = (ZoomControls) findViewById(R.id.zoomControls);
        imageView = (ImageView) findViewById(R.id.imageView);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        displayWidth = dm.widthPixels;
        displayHeight = dm.heightPixels;

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);

        zoomControls.setIsZoomInEnabled(true);
        zoomControls.setIsZoomOutEnabled(true);

        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bmpWidth = bitmap.getWidth();
                int bmpHeight = bitmap.getHeight();

                double scale = 0.8;

                scaleWidth = (float) (scaleWidth * scale);
                scaleHeight = (float) (scaleHeight * scale);

                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);

                Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
                imageView.setImageBitmap(resizeBmp);

            }
        });

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bmpWidth = bitmap.getWidth();
                int bmpHeight = bitmap.getHeight();

                double scale = 1.25;

                scaleWidth = (float) (scaleWidth * scale);
                scaleHeight = (float) (scaleHeight * scale);

                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);

                Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
                imageView.setImageBitmap(resizeBmp);
            }
        });


    }
}
