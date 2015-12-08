package com.example.jizp.chronometer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private Chronometer a = null;
    private Button btn = null;
    private Button btn2 = null;
    private Button btn3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (Chronometer)findViewById(R.id.chronometer);
        a.setFormat("Time:%s");

        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.stop();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.setBase(SystemClock.elapsedRealtime());
            }
        });*/

    }

    public void onStart(View v)
    {
        a.start();
    }

    public void onStop(View v)
    {
        a.stop();

    }

    public void  onReset(View v)
    {
        a.setBase(SystemClock.elapsedRealtime());
    }
}
