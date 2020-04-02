package com.javagroup.javacapstoneapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class mainsection_ResourcesActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    Button btn_funders;
    Button btn_disclaimer;
    Button btn_call1;
    Button btn_call2;

    MainActivity main = new MainActivity();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.btm_sheet_resources);
        setContentView(R.layout.activity_mainsection_resources);


        btn_funders = (Button) findViewById(R.id.btn_funders);
        btn_disclaimer = (Button) findViewById(R.id.btn_disclaimer);


        btn_call1 = findViewById(R.id.imageButton_call_1);
        btn_call2 = findViewById(R.id.imageButton_call_2);

//        btn_call1.setOnClickListener(new View.OnClickListener()
//
//        if(ContextCompat.checkSelfPermission(mainsection_ResourcesActivity.this,
//                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//        {
//
//            ActivityCompat.requestPermissions(mainsection_ResourcesActivity.this,
//                    new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
//        }else
//
//        {
////            @Override
////            public void onClick(View v) {
////                //makePhoneCall();
////            }
////        });
//
//    }
//    
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           @NonNull String[] permissions,
//                                           @NonNull int[] grantResults)
//    {
//        if (requestCode == REQUEST_CALL){
//            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//                makePhoneCall();
//            }else {
//                Toast.makeText(this,"Permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


    }
}
