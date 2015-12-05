package com.example.jizp.onlongclick;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    MainActivity.this.clearWallpaper();
                    ImageView ivv = (ImageView) v;
                    ivv.setDrawingCacheEnabled(true);
                    Bitmap bmp = Bitmap.createBitmap(ivv.getDrawingCache());
                    MainActivity.this.setWallpaper(bmp);
                    iv.setDrawingCacheEnabled(false);
                    Toast.makeText(getApplicationContext(), "Successfull!!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Fuck!!!", Toast.LENGTH_SHORT).show();
                }

                return true;
            }


        });
    }
}
