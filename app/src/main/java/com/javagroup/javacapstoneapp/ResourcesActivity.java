package com.javagroup.javacapstoneapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        Button button= findViewById(R.id.imageButton_call_1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }
    private  void makePhoneCall()
    {


        if(ContextCompat.checkSelfPermission(ResourcesActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(ResourcesActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else
        {
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial ="5879692301";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+dial));
            startActivity(intent);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                makePhoneCall();
            }else {
                Toast.makeText(this,"Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

