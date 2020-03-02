package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView logo;

    TextView school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = (ImageView)findViewById(R.id.imageView);
        school = (TextView)findViewById(R.id.school_text);

        Thread th = new Thread(){
            public void run(){
                try{
                    sleep(5000);

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent mainActivity = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainActivity);
                    finish();
                }
            }
        };
        th.start();
    }
}
