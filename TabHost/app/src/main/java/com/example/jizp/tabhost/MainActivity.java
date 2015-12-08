package com.example.jizp.tabhost;

import android.app.TabActivity;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.view.LayoutInflater;

public class MainActivity extends TabActivity {

    private TabHost tabNews = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        tabNews = this.getTabHost();

        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(R.layout.activity_main,tabNews.getTabContentView(),true);

        tabNews.addTab(tabNews.newTabSpec("Tab1").setIndicator("TextNews", getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.txtnews));
        tabNews.addTab(tabNews.newTabSpec("Tab2").setIndicator("PhotoNews",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.photonews));
        tabNews.addTab(tabNews.newTabSpec("Ta31").setIndicator("VideoNews",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.videonews));

    }
}
