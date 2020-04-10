package com.javagroup.javacapstoneapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.io.InputStream;


public class mainsection_ResourcesActivity extends AppCompatActivity {



    Button btn_funders;
    Button btn_disclaimer;
    Button btn_call1;
    Button btn_call2;
ImageButton imageButton;
ImageButton imageButtonlink1,imageButtonlink2;
    MainActivity main = new MainActivity();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.btm_sheet_resources);
        setContentView(R.layout.activity_mainsection_resources);
         btn_call1 = findViewById(R.id.imageButton_call_1);
        btn_call2 = findViewById(R.id.imageButton_call_2);

        btn_funders = (Button) findViewById(R.id.btn_funders);
        btn_disclaimer = (Button) findViewById(R.id.btn_disclaimer);


        btn_call1 = findViewById(R.id.imageButton_call_1);
        btn_call2 = findViewById(R.id.imageButton_call_2);
        imageButtonlink1 = findViewById(R.id.imageButton_link1);
        imageButtonlink2 = findViewById(R.id.imageButton_link2);
        imageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //makePhoneCall();
            }
        });
        imageButtonlink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                try {
                    InputStream inputStream = getAssets().open("workHealthCenter.html");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    str = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // imageButtonlink1.setText(str);

            }
        });



    }
}
