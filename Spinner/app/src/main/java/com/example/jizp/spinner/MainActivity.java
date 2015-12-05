package com.example.jizp.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner = null;
    private Button btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.province);
        btn = (Button)findViewById(R.id.save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sInfo = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), sInfo, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), sInfo, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
