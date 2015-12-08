package com.example.jizp.contextmenu;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.view.Menu;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        simpleShowList();
        this.registerForContextMenu(getListView());
    }

    private void simpleShowList() {
        String[] files = new String[]{
                "关于工信部网站备案通知.doc",
                "企业年度预决算报表.xls",
                "客户说明会.ppt",
                "企业形像宣传片.avi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,files);

        this.setListAdapter(adapter);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.add(0, 1, Menu.NONE, "蓝牙发送");
        menu.add(0, 2, Menu.NONE, "标记为重要");
        menu.add(0, 3, Menu.NONE, "重命名");
        menu.add(0, 4, Menu.NONE, "删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(getApplicationContext(), "发送文件", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "标记为重要☆☆☆", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "重命名", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(), "删除", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}

