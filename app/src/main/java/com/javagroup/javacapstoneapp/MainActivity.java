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

    public void navToSection1(View view) {
        Intent intent = new Intent(this, OHSActivity.class);
        startActivity(intent);
    }

    public void navToSection2(View view) {
        Intent intent = new Intent(this, OHSActivity.class);
        startActivity(intent);
    }

    public void navToSection3(View view) {
        Intent intent = new Intent(this, OHSActivity.class);
        startActivity(intent);
    }

    public void navToSection4(View view) {
        Intent intent = new Intent(this, ESActivity.class);
        startActivity(intent);
    }

    public void navToSection5(View view) {
        Intent intent = new Intent(this, ESActivity.class);
        startActivity(intent);
    }

    public void navToSection6(View view) {
        Intent intent = new Intent(this, ResourceActivity.class);
        startActivity(intent);
    }


}
