package com.javagroup.javacapstoneapp;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResourcesActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        button1 = findViewById(R.id.btn_dial1);
        button2 = findViewById(R.id.btn_dial2);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openactivity1();
            }

        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openactivity2();
            }
        });
    }
    public void openactivity1(){
       /* Calling inst = new Calling();

        Intent intent = new Intent(this,Calling.class);
       // intent.pu
        //inst.makePhoneCall();
        startActivity(intent);*/


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial ="7804869009";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+dial));
            startActivity(intent);
        }

    }
    public void openactivity2(){
        /*Intent intent = new Intent(this,Calling_Two.class);
        startActivity(intent);*/

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial1 ="4032648100";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+dial1));
            startActivity(intent);
        }
    }

    public void add_to_contact(View view) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        Button  button1 = findViewById(R.id.btnAdd_Contact1);
        intent
                .putExtra(ContactsContract.Intents.Insert.PHONE,button1.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
        startActivity(intent);
    }

    public void add_contact(View view) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        Button  button2 = findViewById(R.id.btnAdd_Contact2);
        intent
                .putExtra(ContactsContract.Intents.Insert.PHONE,button2.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
        startActivity(intent);
    }
}
