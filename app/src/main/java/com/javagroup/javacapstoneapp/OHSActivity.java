package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.TextView;

public class OHSActivity extends AppCompatActivity implements View.OnClickListener {

    TextView ohsActAndCodeLink, safetyRightsLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohs);

        ohsActAndCodeLink = (TextView)findViewById(R.id.ohsActRegAndCodeLink);
        safetyRightsLink = (TextView)findViewById(R.id.safetyRightsLink);

        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);

    }

    private void openingLink (String url) {
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(launchBrowser);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ohsActRegAndCodeLink:
                openingLink ("https://workershealthcentre.ca/4-health-and-safety-rights/");
                break;
            case R.id.safetyRightsLink:
                openingLink ("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                break;
        }
    }
}
