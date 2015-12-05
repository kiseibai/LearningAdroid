package com.example.jizp.oncheckedchangelistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.RenamingDelegatingContext;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton male = null;
    private RadioButton female = null;
    private CheckBox football = null;
    private CheckBox basketball = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        male = (RadioButton)findViewById(R.id.radioButton);
        female =(RadioButton)findViewById(R.id.radioButton2);
        football = (CheckBox)findViewById(R.id.checkBox);
        basketball=(CheckBox)findViewById(R.id.checkBox2);

        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(male.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"男",Toast.LENGTH_SHORT).show();
                }
            }
        });

        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"女",Toast.LENGTH_SHORT).show();
                }
            }
        });

        football.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"足球",Toast.LENGTH_SHORT).show();
                }
            }
        });

        basketball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"篮球",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
