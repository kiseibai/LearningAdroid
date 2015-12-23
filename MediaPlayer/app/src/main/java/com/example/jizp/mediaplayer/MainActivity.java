package com.example.jizp.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    private ImageButton btnPlay, btnPause, btnStop;
    private TextView tvPrompt;
    private MediaPlayer mediaPlayer;

    private boolean isPaused = false;

    private SurfaceView surfaceView = null;
    private SurfaceHolder surfaceHolder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (ImageButton) findViewById(R.id.play);
        btnPause = (ImageButton) findViewById(R.id.pause);
        btnStop = (ImageButton) findViewById(R.id.stop);

        tvPrompt = (TextView) findViewById(R.id.prompt);

        /*mediaPlayer = MediaPlayer.create(this, R.raw.a);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }

                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    tvPrompt.setText("Playing....");
                } catch (
                        Exception e
                        ) {
                    tvPrompt.setText("Play Error....");
                    e.printStackTrace();
                }
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        tvPrompt.setText("Stop....");
                    }

                } catch (
                        Exception e
                        ) {
                    tvPrompt.setText("Stop Error....");
                    e.printStackTrace();
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mediaPlayer != null) {
                        if (isPaused == false) {
                            mediaPlayer.pause();
                            isPaused = true;
                            tvPrompt.setText("Pause....");
                        } else if (isPaused == true) {
                            mediaPlayer.start();
                            isPaused = false;
                            tvPrompt.setText("Pause....");
                        }
                    }

                } catch (
                        Exception e
                        ) {
                    tvPrompt.setText("Pause Error....");
                    e.printStackTrace();
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                try {
                    mediaPlayer.release();
                    tvPrompt.setText("Release");
                } catch (Exception e) {
                    tvPrompt.setText(e.toString());
                    e.printStackTrace();
                }
            }
        });

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                try {
                    //发生错误时,释放资源
                    mp.release();
                    tvPrompt.setText("播放发生异常!");
                } catch (Exception e) {
                    tvPrompt.setText(e.toString());
                    e.printStackTrace();
                }
                return false;
            }
        });*/


        surfaceView = (SurfaceView) findViewById(R.id.surface);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        mediaPlayer = new MediaPlayer();
        try {

            this.mediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/media/w.wmv");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDisplay(MainActivity.this.surfaceHolder);

                try {
                    mediaPlayer.prepare();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        });

        btnStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });


    }
}
