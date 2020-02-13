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

public class Calling_Two extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private EditText mEditTextNumer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling__two);

        mEditTextNumer1 = findViewById(R.id.edit_text_number_two);
        ImageView imagecall_two = findViewById(R.id.image_call_two);

        imagecall_two.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                makePhoneCall_two();
            }


        });
    }
    private void makePhoneCall_two()
    {
        String number = mEditTextNumer1.getText().toString();
        if (number.trim().length()>0)
        {

            if(ContextCompat.checkSelfPermission(Calling_Two.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(Calling_Two.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                // String dial ="tel:" +5879692301;
                //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                String dial1 ="5879692301";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+dial1));
                startActivity(intent);
            }
        }
        else
        {
            Toast.makeText(Calling_Two.this,"Enter Phone number",Toast.LENGTH_SHORT).show();
        }
    }

}
