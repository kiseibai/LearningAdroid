package com.example.jizp.datepickertimepicker;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatePicker today = null;
    private TimePicker now = null;
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //today = (DatePicker) findViewById(R.id.datePicker);
        now = (TimePicker) findViewById(R.id.timePicker);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int iYear = 0;
                int iMonth = 0;
                int iDay = 0;
                String sDate = "";

//                iYear = today.getYear();
//                iMonth = today.getMonth();
//                iDay = today.getFirstDayOfWeek();

                sDate = "Today is:" + iYear + "Year" + iMonth + "Month" + iDay + "Day";

                int iHour = 0;
                int iMin = 0;


                iHour = now.getHour();
                iMin = now.getMinute();

                sDate = sDate + iHour + "Hour" + iMin + "Min";

                Toast.makeText(getApplicationContext(), sDate, Toast.LENGTH_LONG).show();


            }
        });

    }
}
