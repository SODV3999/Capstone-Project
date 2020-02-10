package com.javagroup.javacapstoneapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WorkplaceSafetyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workplace_safety);
    }

    public void navToSection2(View view) {
        Intent intent = new Intent(this, OccupationalHealthAndSafetyActivity.class);
        startActivity(intent);
    }

    public void navToSection3(View view) {
        Intent intent = new Intent(this, OccupationalHealthAndSafetyActivity.class);
        startActivity(intent);
    }

    public void navToSection4(View view) {
        Intent intent = new Intent(this, EmploymentStandardsActivity.class);
        startActivity(intent);
    }

}
