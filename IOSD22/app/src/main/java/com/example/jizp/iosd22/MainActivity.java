package com.example.jizp.iosd22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(getApplicationContext(), "SD card error...", Toast.LENGTH_LONG).show();
                    return;
                }

                String dir = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + "kkk"+File.separator+FILENAME;


                file = new File(dir);


                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }


                /*if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
*/
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

}
