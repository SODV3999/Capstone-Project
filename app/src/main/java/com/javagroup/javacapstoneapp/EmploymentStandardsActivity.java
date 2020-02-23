package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EmploymentStandardsActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_es);
        TextView text = (TextView) findViewById(R.id.textlink);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t = (TextView) findViewById(R.id.employmentcode);
        t.setMovementMethod(LinkMovementMethod.getInstance());
        TextView te = (TextView) findViewById(R.id.EmploymentRegulations);
        te.setMovementMethod(LinkMovementMethod.getInstance());

        button1=findViewById(R.id.button_es_dial1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_es_1();
            }
        });
    }

    public void Activity_es_1(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial_es_1 ="7804272711";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+dial_es_1));
            startActivity(intent);
        }
    }
    public void es_contact_1(View view) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        Button button_es_1 = findViewById(R.id.button_es_contact1);
        intent
                .putExtra(ContactsContract.Intents.Insert.PHONE,button_es_1.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
        startActivity(intent);
    }
}
