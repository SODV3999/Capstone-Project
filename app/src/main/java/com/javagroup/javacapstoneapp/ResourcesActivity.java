package com.javagroup.javacapstoneapp;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResourcesActivity extends AppCompatActivity {

    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        button1 = findViewById(R.id.btn_dial1);
        button2 = findViewById(R.id.btn_dial2);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openactivity1();
            }

        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openactivity2();
            }
        });
    }
    public void openactivity1(){
        Intent intent = new Intent(this,Calling.class);
        startActivity(intent);
    }
    public void openactivity2(){
        Intent intent = new Intent(this,Calling_Two.class);
        startActivity(intent);
    }
}



