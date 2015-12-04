package com.example.k.switchtogglebuttn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Switch wlan = null;
    private ToggleButton gps = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wlan = (Switch) findViewById(R.id.wlan);
        gps = (ToggleButton) findViewById(R.id.gps);

        wlan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_SHORT).show();
                }

            }
        });

        gps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
