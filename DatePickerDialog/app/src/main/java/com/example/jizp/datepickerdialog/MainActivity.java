package com.example.jizp.datepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText et = null;
    private Button btnTime = null;
    private Button btnDate = null;
    private AnalogClock ac = null;
    private DigitalClock dc = null;
    private Calendar c = null;

    Dialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = (Button) findViewById(R.id.button);
        btnTime = (Button) findViewById(R.id.button2);
        et = (EditText)findViewById(R.id.editText);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = onCreateDialog(1);
                dialog.show();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = onCreateDialog(2);
                dialog.show();
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;

        switch (id) {
            case 1:
                c = Calendar.getInstance();
                dialog = new DatePickerDialog(
                        this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                et.setText("Your choice is:" + year + "year" + monthOfYear + "month" + dayOfMonth + "day");

                            }
                        }, c.get(Calendar.YEAR),
                           c.get(Calendar.MONTH),
                           c.get(Calendar.DAY_OF_MONTH));


                break;


            case 2:
                c = Calendar.getInstance();
                dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        et.setText("Your choice is:" + hourOfDay + "Hour" + minute + "Minute");

                    }
                }, c.getTime().getHours(), c.getTime().getMinutes(), false);
                break;

        }
        return dialog;
    }


}

