package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigateToES(View view) {
        Intent intent = new Intent(this, ESActivity.class);
        startActivity(intent);
    }

    public void navigateToResources(View view) {
        Intent intent = new Intent(this, ResourceActivity.class);
        startActivity(intent);
    }


}
