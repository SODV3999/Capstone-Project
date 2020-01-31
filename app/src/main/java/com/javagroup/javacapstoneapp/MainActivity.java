package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOHS(View view) {
        message = "Redirect to OHS page";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClickEmpStandards(View view) {
        message = "Redirect to Employment Standards page";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClickHumanRights(View view) {
        message = "Redirect to Human Rights page";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
