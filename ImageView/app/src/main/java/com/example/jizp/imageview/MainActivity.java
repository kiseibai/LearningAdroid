package com.example.jizp.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview = null;
    private Button prov = null;
    private Button next = null;
    private Integer[] images = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.i, R.mipmap.j, R.mipmap.k, R.mipmap.l};
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.snowmama);
        prov = (Button) findViewById(R.id.prov);
        next = (Button) findViewById(R.id.next);

        prov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0)
                {
                    imageview.setImageResource(images[--i]);
                }
                else if(i==0)
                {
                    i=12;
                    imageview.setImageResource(images[i-1]);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<12)
                {
                    imageview.setImageResource(images[i++]);
                }
                else if(i==12)
                {
                    i=0;
                    imageview.setImageResource(images[i]);
                }

            }
        });

    }
}
