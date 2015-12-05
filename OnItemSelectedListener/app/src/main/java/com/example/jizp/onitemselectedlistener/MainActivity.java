package com.example.jizp.onitemselectedlistener;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner provinceList = null;
    private Spinner cityList = null;
    private String[][] arryCity = new String[][]{
            {"济南", "青岛", "淄博"},
            {"南京", "镇江", "常州"},
            {"徐汇", "闸北", "松江"},
            {"杭州", "嘉兴", "宁波"},
            {"厦门", "福州", "莆田"},
            {"广州", "东莞", "深圳"}
    };

    private ArrayAdapter<CharSequence> adapterCity = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        provinceList = (Spinner) findViewById(R.id.spinner);
        cityList = (Spinner) findViewById(R.id.spinner2);


        provinceList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //adapterCity = new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item, arryCity[position]);

                adapterCity = new ArrayAdapter<CharSequence>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arryCity[position]);

                cityList.setAdapter(adapterCity);

                //Toast.makeText(getApplicationContext(), provinceList.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing!!!", Toast.LENGTH_SHORT).show();
            }
        });

        cityList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String sInfo = parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), sInfo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing!!!", Toast.LENGTH_SHORT).show();
            }


        });

    }
}
