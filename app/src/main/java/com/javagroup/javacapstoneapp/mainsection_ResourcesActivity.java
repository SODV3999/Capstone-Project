package com.javagroup.javacapstoneapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class mainsection_ResourcesActivity extends AppCompatActivity
{

    private static final int REQUEST_CALL = 1 ;

    Button btn_funders;
    Button btn_disclaimer;
    MainActivity main = new MainActivity();

//    public void changeActivity(Class targetClass ){
//        Log.d("changeActivity: ", "Clicked");
//        Intent intent = new Intent(this, targetClass);
//        startActivity(intent);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsection_resources);

        btn_funders = (Button)findViewById(R.id.btn_funders);
        btn_disclaimer = (Button)findViewById(R.id.btn_disclaimer);



//
//        btn_disclaimer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeActivity(Disclaimer.class);
//            }
//        });


//        Button button= findViewById(R.id.imageButton_call_1);
//        button.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                makePhoneCall();
//            }
//        });
    }
    private  void makePhoneCall()
    {


        if(ContextCompat.checkSelfPermission(mainsection_ResourcesActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(mainsection_ResourcesActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
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
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
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

