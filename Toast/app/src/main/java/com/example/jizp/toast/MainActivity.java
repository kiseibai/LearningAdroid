package com.example.jizp.toast;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.util.GregorianCalendar;
import java.util.logging.LogRecord;

public class MainActivity extends Activity implements OnClickListener {

    Handler handler = new Handler();

    private Button btnOriginal = null;
    private Button btnByPhoto = null;
    private Button btnCustomPosition = null;
    private Button btnAllDiy = null;
    private Button btnThread = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得按钮
        btnOriginal = (Button) super.findViewById(R.id.original);
        btnByPhoto = (Button) super.findViewById(R.id.byphoto);
        btnCustomPosition = (Button) super.findViewById(R.id.customposition);
        btnAllDiy = (Button) super.findViewById(R.id.alldiy);
        btnThread = (Button) super.findViewById(R.id.bythread);
        //设置OnClick监听事件
        btnOriginal.setOnClickListener(this);
        btnByPhoto.setOnClickListener(this);
        btnCustomPosition.setOnClickListener(this);
        btnAllDiy.setOnClickListener(this);
        btnThread.setOnClickListener(this);
    }

    public void showToast() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "我来自其他线程！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast toast = null;
        switch (v.getId()) {

            case R.id.original:
                Toast.makeText(getApplication(), "默认Toast样式", Toast.LENGTH_SHORT).show();
                break;

            case R.id.byphoto:
                toast = Toast.makeText(getApplicationContext(), "带图片的Toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);

                LinearLayout toastView = (LinearLayout) toast.getView();

                ImageView imageCodeProject = new ImageView(this);
                imageCodeProject.setImageResource(R.mipmap.ic_launcher);

                toastView.addView(imageCodeProject,1);
                toast.show();
                break;

            case R.id.customposition:
                toast = Toast.makeText(getApplicationContext(), "自定义位置Toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.LEFT, 100, 100);
                toast.show();
                break;

            case R.id.alldiy:
                /* setContentView()一旦调用, layout就会立刻显示UI；而inflate只会把Layout形成一个以view类实现成的
                 * 对象。 有需要时再用setContentView(view)显示出来。一般在activity中通过setContentView()将界面显
                 * 示出来，但是 如果在非activity中如何对控件布局设置操作了，这就需要LayoutInflater动态加载。      */
                LayoutInflater inflater = getLayoutInflater();
                //inflate(int Resourece,ViewGroup root)作用：填充一个新的视图层次结构从指定的XML资源文件中
                View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.customtoast));
                //加载图像
                ImageView image = (ImageView) layout.findViewById(R.id.picture);
                image.setImageResource(R.mipmap.ic_launcher);
                //设置标题
                TextView title = (TextView) layout.findViewById(R.id.titletoast);
                title.setText("完全自定义Toast");
                //显示内容
                TextView text = (TextView) layout.findViewById(R.id.prompt);
                text.setText("显示提示信息……");
                toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.LEFT | Gravity.TOP, 12, 40);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                break;

            case R.id.bythread:
                //实例化线程
                new Thread(new Runnable() {
                    public void run() {
                        showToast();
                    }
                }).start();
                break;


        }

    }
}
