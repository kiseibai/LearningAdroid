package com.example.jizp.oncheckedchangelistenerbuttongroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg = null;
    private Button male = null;
    private Button female = null;
    private CheckBox football = null;
    private CheckBox basketball = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
        male=(RadioButton)findViewById(R.id.radioButton);
        female=(RadioButton)findViewById(R.id.radioButton2);
        football=(CheckBox)findViewById(R.id.checkBox);
        basketball=(CheckBox)findViewById(R.id.checkBox2);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(male.getId()== checkedId)
                {
                    Toast.makeText(getApplicationContext(),"Male",Toast.LENGTH_SHORT).show();
                }
                else if(female.getId() == checkedId)
                {
                    Toast.makeText(getApplicationContext(),"Female",Toast.LENGTH_SHORT).show();
                }
            }
        });

        football.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"Checked Football",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Unchecked Football",Toast.LENGTH_SHORT).show();
                }
            }
        });

        basketball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(getApplicationContext(),"Checked Basketball",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Unchecked Basketball",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
