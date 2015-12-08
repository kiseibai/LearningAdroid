package com.example.jizp.slidingdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SlidingDrawer slidingDrawer = null;
    private ListView listView = null;
    private Button btn = null;
    private String news[] = {
            "互联网产品中的情感化设计",
            "有效导向社交产品的商业价值",
            "移动开发者：得90后者得天下",
            "用户体验：从App的加载页面说开去",
            "用扁平化的界面设计吸引用户",
            "实体与数字世界的交集",
            "网络社区用户成长的5个思考模式",
            "十大值得关注的传统企业电商",
            "2013年十大热点技术发展趋势",
            "了解产品的开发环节：环形设计论",
            "客户忠诚度的四个层次",
            "在手机背面贴张'纸'就能轻松充电",
            "互联网公司是怎样激发你的消费欲望的",
            "高效工作的信息搜集及管理术"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);
        listView = (ListView) findViewById(R.id.content);
        btn = (Button) findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,news);
        listView.setAdapter(adapter);

        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                Toast.makeText(getApplicationContext(),"DrawerOpened", Toast.LENGTH_LONG).show();

            }
        });

        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                Toast.makeText(getApplicationContext(),"DrawerClosed", Toast.LENGTH_LONG).show();

            }
        });

        slidingDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
            @Override
            public void onScrollStarted() {
                Toast.makeText(getApplicationContext(),"ScrollStarted", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onScrollEnded() {
                Toast.makeText(getApplicationContext(),"ScrollEnded", Toast.LENGTH_LONG).show();

            }
        });

        slidingDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"onClick", Toast.LENGTH_LONG).show();

            }
        });

    }
}
