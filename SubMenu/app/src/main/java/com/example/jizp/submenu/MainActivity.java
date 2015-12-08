package com.example.jizp.submenu;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "蓝牙发送").setIcon(R.mipmap.ic_launcher);
        SubMenu subMenu = menu.addSubMenu(0, 2, Menu.NONE, "重要程度>>>").setIcon(R.mipmap.ic_launcher);
        subMenu.add(1, 101, 1, "★★★★★");
        subMenu.add(1, 102, 2, "★★★★");
        subMenu.add(1, 103, 3, "★★★");
        subMenu.add(1, 104, 4, "★★");
        subMenu.add(1, 105, 5, "★");
        menu.add(0, 3, Menu.NONE, "重命名").setIcon(R.mipmap.ic_launcher);
        menu.add(0, 4, Menu.NONE, "删除").setIcon(R.mipmap.ic_launcher);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case 1:
                Toast.makeText(getApplicationContext(), "蓝牙发送……", Toast.LENGTH_SHORT).show();
                return true;

            case 101:
                Toast.makeText(getApplicationContext(), "非常重要：☆☆☆☆☆", Toast.LENGTH_SHORT).show();
                return true;
            case 102:
                Toast.makeText(getApplicationContext(), "重要：☆☆☆", Toast.LENGTH_SHORT).show();
                return true;
            case 103:
                Toast.makeText(getApplicationContext(), "普通：☆", Toast.LENGTH_SHORT).show();
                return true;

            case 3:
                Toast.makeText(getApplicationContext(), "重命名……", Toast.LENGTH_SHORT).show();
                return true;

            case 4:
                Toast.makeText(getApplicationContext(), "删除……", Toast.LENGTH_SHORT).show();
                return true;

        }
        return false;
    }
}


