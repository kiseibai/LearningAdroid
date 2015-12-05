package com.example.jizp.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int selectedCityIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //简单对话框
//        AlertDialog.Builder adInfo = new AlertDialog.Builder(this);
//        adInfo.setTitle("简单对话框");
//        adInfo.setMessage("这是一个美丽的传说，精美的石头会唱歌……");
//        adInfo.setIcon(R.mipmap.ic_launcher);
//        adInfo.create();
//        adInfo.show();

        //带按钮对话框
//        AlertDialog.Builder adInfo1 = new AlertDialog.Builder(this);
//        adInfo1.setTitle("确定删除？");
//        adInfo1.setMessage("您确定删除该条信息吗？");
//        adInfo1.setIcon(R.mipmap.ic_launcher);
//
//        adInfo1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        adInfo1.setNeutralButton("详细", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        adInfo1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        adInfo1.create();
//        adInfo1.show();

        final String[] arrayCity = new String[]{"손을 내려놓고 말았어", "친구잖아 친구잖아 친구잖아", "난 어차피 너에게 난", "그냥 좋은 친구잖아"};
        final boolean[] checkItem = new boolean[]{false, false, false, false};

//        AlertDialog.Builder adInfo2 = new AlertDialog.Builder(this).
//                setTitle("울고 있는 네 어깨를 감싸려다")
//                .setIcon(R.mipmap.ic_launcher)
//                .setSingleChoiceItems(arrayCity, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        selectedCityIndex = which;
//                    }
//                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).setNeutralButton("More...", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), "Your Choice is:" + arrayCity[selectedCityIndex], Toast.LENGTH_LONG).show();
//                    }
//                });
//        adInfo2.create().show();

        AlertDialog.Builder sInfo3 = new AlertDialog.Builder(this)
                .setTitle("울고 있는 네 어깨를 감싸려다")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(arrayCity, checkItem, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkItem[which] = isChecked;
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("More...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder sb = new StringBuilder();

                        for (int i = 0; i < checkItem.length; i++) {
                            if(checkItem[i]==true)
                            {
                                sb.append(arrayCity[i]);
                            }
                        }

                        Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_LONG).show();


                    }
                });
        sInfo3.create().show();


    }
}
