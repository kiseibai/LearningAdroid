package com.example.jizp.radiogroupcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButtonMale = null;
    private RadioButton radioButtonFemale = null;
    private CheckBox checkBoxFootball = null;
    private CheckBox checkBoxBasketball = null;
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        checkBoxFootball = (CheckBox) findViewById(R.id.checkBoxFootball);
        checkBoxBasketball = (CheckBox) findViewById(R.id.checkBoxBasketball);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new SaveOnClickListener());
    }

    private class SaveOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String sex = "";
            String player = "";
            String sInfo = "";

            if (radioButtonMale.isChecked()) {
                sex = radioButtonMale.getText().toString();
            }

            if (radioButtonFemale.isChecked()) {
                sex = radioButtonFemale.getText().toString();
            }

            if (checkBoxFootball.isChecked()) {
                player = player + checkBoxFootball.getText().toString();
            }

            if (checkBoxBasketball.isChecked()) {
                player = player + checkBoxBasketball.getText().toString();
            }

            sInfo = "SEX：" + sex + "Play" + player;

            Toast.makeText(getApplicationContext(), sInfo, Toast.LENGTH_LONG).show();
        }
    }
}
