package com.example.jizp.iosd;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends Activity {

    private Button btnSave = null;
    private Button btnRead = null;
    private File filepath = null;
    private File file = null;

    private static final String FILENAME = "data.txt";

    private static final int REQUEST_CODE_ASK_PERMISSIONS_WRITE = 1;
    private static final int REQUEST_CODE_ASK_PERMISSIONS_READ = 2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.save);
        btnRead = (Button) findViewById(R.id.read);

        btnSave.setOnClickListener(new SaveOnClickListener());
        btnRead.setOnClickListener(new ReadOnClickListener());
    }

    private class SaveOnClickListener implements View.OnClickListener {
        public void onClick(View v) {

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS_WRITE);
                return;
            }

            SaveFile();
        }
    }

    private class ReadOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {


            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS_READ);
                return;
            }

            ReadFile();
        }
    }

    private void SaveFile() {
        PrintStream ps = null;

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(getApplicationContext(), "SD card error...", Toast.LENGTH_LONG).show();
            return;
        }

        String dir = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + "kkk";

        file = new File(dir, FILENAME);


        if (!file.exists()) {
            file.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ps = new PrintStream(fileOutputStream);
            ps.println("网址：www.kkk.com");
            ps.println("电子邮件：k@kkk.com");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }

    private void ReadFile() {

        StringBuffer info = new StringBuffer();

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(getApplicationContext(), "SD card error...", Toast.LENGTH_LONG).show();
            return;
        }

        String path = Environment.getExternalStorageDirectory().toString() + File.separator + "kkk" + File.separator + FILENAME;
        file = new File(path);

        if (!file.exists()) {
            Toast.makeText(getApplicationContext(), "File is not exist...", Toast.LENGTH_LONG).show();
            return;
        }

        Scanner scanner = null;

        try {
            scanner = new Scanner(new FileInputStream(file));
            while (scanner.hasNext()) {
                info.append(scanner.next()).append("★★★\n");
            }
            Toast.makeText(getApplicationContext(), info.toString(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS_WRITE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    SaveFile();

                } else {
                    Toast.makeText(getApplicationContext(), "PERMISSION WRITE ERROR", Toast.LENGTH_LONG).show();
                }
                break;
            case REQUEST_CODE_ASK_PERMISSIONS_READ:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    ReadFile();

                } else {
                    Toast.makeText(getApplicationContext(), "PERMISSION READ ERROR", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
