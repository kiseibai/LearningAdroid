package com.example.jizp.iosd;

import android.Manifest;
import android.app.Activity;
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

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.save);
        btnRead = (Button) findViewById(R.id.read);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrintStream ps = null;

/*                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    Activity.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            WRITE_EXTERNAL_STORAGE_REQUEST_CODE);

                    Activity.
                }*/


                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(getApplicationContext(), "SD card error...", Toast.LENGTH_LONG).show();
                    return;
                }

                String dir = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + "kkk";

                //file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS);
                file = new File(dir, FILENAME);


                if (!file.exists()) {
                    file.mkdirs();
                }

                /*String filetmp = filepath.getAbsolutePath() + File.separator + FILENAME;
                try {
                    String filetmp1 = filepath.getCanonicalPath() + File.separator + FILENAME;
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

                //file = new File(filepath);

                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    //FileOutputStream fileOutputStream = openFileOutput(path, BIND_AUTO_CREATE);
                    ps = new PrintStream(fileOutputStream);
                    ps.println("网址：www.kkk.com");
                    ps.println("电子邮件：k@kkk.com");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    ps.close();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

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

                                   }

        );
    }


/*    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    insertDummyContact();
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "WRITE_CONTACTS Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/
}
