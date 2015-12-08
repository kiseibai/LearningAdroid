package com.example.jizp.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.fathergridview);
        ArrayList<HashMap<String, Object>> listImageItem = new ArrayList<HashMap<String, Object>>();




        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> mapItem = new HashMap<String, Object>();
            mapItem.put("ItemImage", R.mipmap.ic_launcher);
            mapItem.put("ItemText", "NO." + String.valueOf(i));
            listImageItem.add(mapItem);
        }

        SimpleAdapter xxx = new SimpleAdapter(this,
                listImageItem,
                R.layout.grid,
                new String[]{"ItemImage", "ItemText"},
                new int[]{R.id.ItemImage, R.id.ItemText});

        gridview.setAdapter(xxx);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
                setTitle((String) item.get("ItemText"));

            }
        });
    }
}
