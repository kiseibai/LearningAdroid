package com.example.jizp.autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {

    private static final String[] cities = new String[]{
            "南京", "镇江", "常州", "苏州", "南通", "盐城", "连云港", "徐州", "宿迁", "淮安", "扬州", "泰州"
    };

    private static final String[] cities1 = new String[]{
            "nanjing", "zhenjiang", "changzhou", "shuzhou", "nantong", "yanchen", "lianyungang", "xuzhou", "shuqian", "huaian", "yangzhou", "taizhou"
    };

    private AutoCompleteTextView single = null;
    private MultiAutoCompleteTextView multi = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        single = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cities1);

        single.setAdapter(adapter);
        single.setThreshold(1);

        multi.setAdapter(adapter);
        multi.setThreshold(1);
        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
