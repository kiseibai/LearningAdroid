package com.example.jizp.progressdialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCircle = null;
    private Button btnPrggress = null;
    private ProgressDialog pdDialog = null;
    int iCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCircle = (Button) findViewById(R.id.cricle);
        btnPrggress = (Button) findViewById(R.id.progress);

        btnCircle.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             iCount = 0;
                                             pdDialog = new ProgressDialog(MainActivity.this);

                                             pdDialog.setTitle("圆形进度条");
                                             pdDialog.setIcon(R.mipmap.ic_launcher);
                                             pdDialog.setMessage("正在下载...");
                                             pdDialog.setProgress(100);
                                             pdDialog.setIndeterminate(false);
                                             pdDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                                             pdDialog.setCancelable(true);
                                             pdDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
                                                 @Override
                                                 public void onClick(DialogInterface dialog, int which) {
                                                     dialog.cancel();
                                                 }
                                             });

                                             pdDialog.show();

                                             new Thread() {
                                                 public void run() {
                                                     try {
                                                         while (iCount <= 100) {
                                                             pdDialog.setProgress(iCount++);
                                                             java.lang.Thread.sleep(50);
                                                         }
                                                         pdDialog.cancel();
                                                     } catch (InterruptedException e) {
                                                         pdDialog.cancel();
                                                     }
                                                 }
                                             }.start();
                                         }
                                     }

        );

        btnPrggress.setOnClickListener(new View.OnClickListener()

                                       {
                                           @Override
                                           public void onClick(View v) {

                                               iCount = 0;
                                               pdDialog = new ProgressDialog(MainActivity.this);

                                               pdDialog.setTitle("条形进度条");
                                               pdDialog.setIcon(R.mipmap.ic_launcher);
                                               pdDialog.setMessage("正在下载...");
                                               pdDialog.setProgress(100);
                                               pdDialog.setIndeterminate(false);
                                               pdDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                                               pdDialog.setCancelable(true);
                                               pdDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
                                                   @Override
                                                   public void onClick(DialogInterface dialog, int which) {
                                                       dialog.cancel();
                                                   }
                                               });

                                               pdDialog.show();

                                               new Thread() {
                                                   public void run() {
                                                       try {
                                                           while (iCount <= 100) {
                                                               pdDialog.setProgress(iCount++);
                                                               java.lang.Thread.sleep(50);
                                                           }
                                                           pdDialog.cancel();
                                                       } catch (InterruptedException e) {
                                                           pdDialog.cancel();
                                                       }
                                                   }
                                               }.start();

                                           }
                                       }

        );
    }
}
