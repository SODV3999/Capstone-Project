package com.javagroup.javacapstoneapp;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import android.widget.TextView;

public class ResourcesActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout browserContainer;

    float x1, x2, y1, y2;

    private Button dial1, dial2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        TextView healthCenterLink = (TextView) findViewById(R.id.txt_health_center);
        TextView resourceCenterLink = (TextView) findViewById(R.id.txt_Resource_Center);

        dial1 = (Button)findViewById(R.id.btn_dial1);
        dial2 = (Button)findViewById(R.id.btn_dial2);

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        healthCenterLink.setOnClickListener(this);
        resourceCenterLink.setOnClickListener(this);
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

    private void openingLink(String url){
        browserContainer.setTranslationY(3000);
        browserContainer.animate().translationYBy(-3000).setDuration(700);
        final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
        final WebBrowserActivity webBrowserActivity = new WebBrowserActivity();
        Bundle link = new Bundle();
        link.putString("url", url);
        webBrowserActivity.setArguments(link);
        openTheBrowser.add(R.id.browserContainer, webBrowserActivity);
        openTheBrowser.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_health_center:
                openingLink("https://www.workershealthcentre.ca/");
                break;
            case R.id.txt_Resource_Center:
                openingLink("https://www.helpwrc.org/");
                break;
        }
    }
}

      /*  button = (Button) findViewById(R.id.btn_dial1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0377778888"));

                if (ActivityCompat.checkSelfPermission(ResourecActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

    }
}*/
