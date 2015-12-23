package com.example.jizp.resourcefile;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends Activity {

    private Button btnRead = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = (Button)findViewById(R.id.read);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();

                InputStream input = res.openRawResource(R.raw.friend);

                Scanner scanner = new Scanner(input);
                StringBuffer stringBuffer = new StringBuffer();
                while (scanner.hasNext())
                {
                    stringBuffer.append(scanner.next()).append("\n");
                }

                scanner.close();

                try{
                    input.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),stringBuffer,Toast.LENGTH_LONG).show();
            }
        });
    }
}
