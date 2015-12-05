package com.example.jizp.seekbar;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar skVolimer = null;
    private TextView tvinfo1 = null;
    private TextView tvinfo2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skVolimer = (SeekBar)findViewById(R.id.seekBar);
        tvinfo1 = (TextView)findViewById(R.id.tvinfo1);
        tvinfo2 =(TextView)findViewById(R.id.tvinfo2);

        skVolimer.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromTouch)
    {
        tvinfo1.setText("Value:"+progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tvinfo2.setText("音量正在调解");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tvinfo2.setText("音量停止调解");

    }

}
