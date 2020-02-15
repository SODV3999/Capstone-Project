package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

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
