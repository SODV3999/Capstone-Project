package com.javagroup.javacapstoneapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;


public class mainsection_ResourcesActivity extends AppCompatActivity {


    Button btn_funders;
    Button btn_disclaimer;
    Button btn_call1;
    Button btn_call2;
    ImageButton imageButton;
    ImageButton imageButtonlink1, imageButtonlink2;
    MainActivity main = new MainActivity();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainsection_resources);
        btn_call1 = findViewById(R.id.imageButton_call_1);
        btn_call2 = findViewById(R.id.imageButton_call_2);

        btn_funders = findViewById(R.id.btn_funders);
        btn_disclaimer = findViewById(R.id.btn_disclaimer);

        btn_call1 = findViewById(R.id.imageButton_call_1);
        btn_call2 = findViewById(R.id.imageButton_call_2);
//        imageButtonlink1 = findViewById(R.id.imageButton_link1);
//        imageButtonlink2 = findViewById(R.id.imageButton_link2);

    }
}
