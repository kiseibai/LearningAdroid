package com.example.jizp.listviewimage;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //setListAdapter(new SimpleAdapter(this, getdata(), R.layout.activity_main, new String[]{"title", "info", "picture"}, new int[]{R.id.title, R.id.info, R.id.picture}));

        SimpleAdapter adapter = new SimpleAdapter(this, getdata(),
                R.layout.activity_main,
                new String[]{"title", "info", "picture"},
                new int[]{R.id.title, R.id.info, R.id.picture});

        setListAdapter(adapter);
    }

    private List<Map<String, Object>> getdata() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "图片");
        map.put("info", "美辰良景，给你无限的遐思，让人感觉无限温馨……");
        map.put("picture", R.mipmap.photo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "音乐");
        map.put("info", "轻曼音乐，令人如入仙境，如痴如醉……");
        map.put("picture", R.mipmap.music);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "视频");
        map.put("info", "震撼场景，360度的视觉捕获，一览无遗……");
        map.put("picture", R.mipmap.video);
        list.add(map);

        return list;
    }
}
