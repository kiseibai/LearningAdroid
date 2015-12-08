package com.example.jizp.tabhostwhitouttabactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tbhost = (TabHost)findViewById(R.id.tabhost);
        tbhost.setup();

        TabWidget tabWidget = tbhost.getTabWidget();

        tbhost.addTab(tbhost.newTabSpec("tab1").setIndicator("TextNews",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.txt));
        tbhost.addTab(tbhost.newTabSpec("tab2").setIndicator("PhotoNews",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.phone));
        tbhost.addTab(tbhost.newTabSpec("tab3").setIndicator("VideoNews",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.video));
    }
}
