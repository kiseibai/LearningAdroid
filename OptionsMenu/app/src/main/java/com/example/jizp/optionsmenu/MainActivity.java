package com.example.jizp.optionsmenu;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.view.LayoutInflater;

import java.util.zip.Inflater;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.connect:
                Toast.makeText(getApplicationContext(), "蓝牙连接……", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.disconnect:
                Toast.makeText(getApplicationContext(), "蓝牙断开……", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(getApplicationContext(), "寻找蓝牙……", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.view:
                Toast.makeText(getApplicationContext(), "查看……", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(getApplicationContext(), "帮助……", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.exit:
                Toast.makeText(getApplicationContext(), "退出……", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
