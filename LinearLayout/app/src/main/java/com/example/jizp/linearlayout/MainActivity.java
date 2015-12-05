package com.example.jizp.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout llLayout = new LinearLayout(this);
        LinearLayout.LayoutParams lpPara = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        llLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams btnPara = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button btnFourth = new Button(this);
        btnFourth.setLayoutParams(btnPara);
        btnFourth.setText("第四个按钮");

        Button btnFifth = new Button(this);
        btnFifth.setLayoutParams(btnPara);
        btnFifth.setText("第五个按钮");

        Button btnSixth = new Button(this);
        btnSixth.setLayoutParams(btnPara);
        btnSixth.setText("第六个按钮");

        llLayout.addView(btnFourth);
        llLayout.addView(btnFifth);
        llLayout.addView(btnSixth);

        addContentView(llLayout, lpPara);


    }
}
