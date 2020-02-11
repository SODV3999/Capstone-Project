package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class OccupationalHealthAndSafetyActivity extends AppCompatActivity implements View.OnClickListener {

    TextView ohsActAndCodeLink, safetyRightsLink;
    WebView browser;
    Button closeBrowser;

    ConstraintLayout browserScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohs);

        ohsActAndCodeLink = (TextView)findViewById(R.id.ohsActRegAndCodeLink);
        safetyRightsLink = (TextView)findViewById(R.id.safetyRightsLink);

        browser = (WebView)findViewById(R.id.webView);

        closeBrowser = (Button)findViewById((R.id.closebrowser));

        browserScreen = (ConstraintLayout)findViewById(R.id.browserScreen);

        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);
        closeBrowser.setOnClickListener(this);


    }

    private void openingLink(String url){
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //startActivity(intent);
        browser.setWebViewClient(new WebViewClient());
        //WebSettings
        browser.loadUrl(url);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ohsActRegAndCodeLink:
                openingLink ("https://workershealthcentre.ca/4-health-and-safety-rights/");
                browserScreen.setVisibility(View.VISIBLE);
                break;
            case R.id.safetyRightsLink:
                openingLink ("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                browserScreen.setVisibility(View.VISIBLE);
                break;
            case R.id.closebrowser:
                if(browserScreen.getVisibility() == View.VISIBLE)
                {
                    browserScreen.setVisibility(View.INVISIBLE);
                }else{
                    browserScreen.setVisibility(View.VISIBLE);
                }
        }
    }
}
