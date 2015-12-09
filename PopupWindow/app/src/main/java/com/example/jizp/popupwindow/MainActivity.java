package com.example.jizp.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.PopupWindow;
import android.view.Menu;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

    private int[] resArray = new int[]
            {
                    R.drawable.a,
                    R.drawable.b,
                    R.drawable.c,
                    R.drawable.d
            };

    private String[] title = new String[]
            {
                    "添加", "信息", "搜索", "查看"
            };

    private PopupWindow pw = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("");
        return onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (pw != null) {

            if (pw.isShowing()) {
                pw.dismiss();
            } else {
                pw.showAtLocation(findViewById(R.id.hello), Gravity.CENTER, 0, 300);
            }

        } else {

            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.menu, null);
            GridView gridView = (GridView) findViewById(R.id.menuGridChange);
            gridView.setAdapter(new ImageAdapter(this));
            pw.showAtLocation(findViewById(R.id.hello), Gravity.CENTER, 0, 300);

        }
        return false;
    }


    public boolean onKeyDown(int keyCode, KeyEvent envet) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            pw.dismiss();
            return false;
        }

        return onKeyDown(keyCode, envet);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return resArray.length;
        }

        @Override
        public Object getItem(int arg0) {
            return resArray[arg0];
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }


        @Override   //实现图标下包含字符效果
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            LinearLayout linear = new LinearLayout(context);
            LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            linear.setOrientation(LinearLayout.VERTICAL);
            ImageView iv = new ImageView(context);
            iv.setImageBitmap(((BitmapDrawable) context.getResources().getDrawable(resArray[arg0])).getBitmap());
            LinearLayout.LayoutParams params2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params2.gravity = Gravity.CENTER;
            linear.addView(iv, params2);
            TextView tv = new TextView(context);
            tv.setText(title[arg0]);
            LinearLayout.LayoutParams params3 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params3.gravity = Gravity.CENTER;
            linear.addView(tv, params3);
            return linear;
        }
    }

}


