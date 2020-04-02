package com.javagroup.javacapstoneapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ResourcesActivity extends AppCompatActivity
{

    private static final int REQUEST_CALL = 1 ;

    Button btn_funders;
    Button btn_disclaimer;
    Button btn_call1;
    Button btn_call2;

    MainActivity main = new MainActivity();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btm_sheet_resources);

        btn_funders = (Button)findViewById(R.id.btn_funders);
        btn_disclaimer = (Button)findViewById(R.id.btn_disclaimer);






         btn_call1 = findViewById(R.id.imageButton_call_1);
         btn_call2 = findViewById(R.id.imageButton_call_2);

        btn_call1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //makePhoneCall();
            }
        });

    }



}

