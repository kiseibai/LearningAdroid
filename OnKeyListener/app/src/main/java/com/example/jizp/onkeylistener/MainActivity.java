package com.example.jizp.onkeylistener;

import android.support.v4.view.KeyEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et = null;
    private TextView tt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        tt = (TextView) findViewById(R.id.textView);

        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String news = null;
                if (event.getAction() == KeyEvent.ACTION_UP) {

                    tt.setText(et.getText().toString());


                } else if (event.getAction() == KeyEvent.ACTION_DOWN) {

                }

                return false;
            }
        });
    }
}
