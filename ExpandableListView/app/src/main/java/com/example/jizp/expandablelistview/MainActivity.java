package com.example.jizp.expandablelistview;

import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Gravity;

public class MainActivity extends Activity {

    private String[] province = new String[]{"山东", "江苏", "上海"};
    private String[][] city = new String[][]{
            {"济南", "青岛", "日照", "烟台", "威海"},
            {"南京", "镇江", "常州", "无锡", "苏州"},
            {"徐汇", "浦东", "闸北", "松江", "奉贤"}
    };
    private ExpandableListView elv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);

                TextView textView = new TextView(MainActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                textView.setTextColor(Color.BLACK);
                return textView;

            }

            @Override
            public int getGroupCount() {
                return province.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return city[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return province[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return city[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return 0;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(MainActivity.this);
                ll.setOrientation(0);
                TextView textView = getTextView();
                textView.setTextColor(Color.BLACK);
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

                LinearLayout ll = new LinearLayout(MainActivity.this);
                ll.setOrientation(0);
                TextView textView = getTextView();
                textView.setTextColor(Color.BLACK);
                textView.setText(getChild(groupPosition, childPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }
        };

        elv = (ExpandableListView)findViewById(R.id.expandableListView);
        elv.setAdapter(adapter);

        elv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });

        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
    }
}
