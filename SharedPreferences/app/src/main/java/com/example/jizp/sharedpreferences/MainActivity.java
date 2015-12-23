package com.example.jizp.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btnSave = null;
    private Button btnRead = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button)findViewById(R.id.save);
        btnRead = (Button)findViewById(R.id.read);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("kkk", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("url","www.kkk.com");
                editor.putString("email","k@kkk.com");
                editor.commit();
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("kkk",MODE_PRIVATE);
                String url = sharedPreferences.getString("url","");
                String email = sharedPreferences.getString("email","");
                String  info ="url:"+url+";"+"email:"+email;
                Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();
            }
        });

    }
}
