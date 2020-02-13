package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



public class Calling extends AppCompatActivity {
private static final int REQUEST_CALL = 1;
        private EditText mEditTextNumer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

        mEditTextNumer = findViewById(R.id.edit_text_number);
        ImageView imagecall = findViewById(R.id.image_call);

        imagecall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }


        });
    }
    private void makePhoneCall()
    {
        String number = mEditTextNumer.getText().toString();
        if (number.trim().length()>0)
        {

            if(ContextCompat.checkSelfPermission(Calling.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(Calling.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                // String dial ="tel:" +5879692301;
                //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                String dial ="5879692301";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+dial));
                startActivity(intent);
            }
        }
        else
        {
            Toast.makeText(Calling.this,"Enter Phone number",Toast.LENGTH_SHORT).show();
        }
    }
}
