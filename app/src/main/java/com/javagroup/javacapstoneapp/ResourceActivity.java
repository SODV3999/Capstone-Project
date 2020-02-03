package com.javagroup.javacapstoneapp;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.txt_health_center);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView t = (TextView) findViewById(R.id.txt_Resource_Center);
        t.setMovementMethod(LinkMovementMethod.getInstance());

        Button dial1 = findViewById(R.id.btn_dial1);
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
           // button.setOnClickListener(new View.OnClickListener(){
    public void OnDialButton(View v) {
        Intent callIntent  = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:7804869009"));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivity(callIntent);
    }

}

      /*  button = (Button) findViewById(R.id.btn_dial1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0377778888"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

    }
}*/
