package com.javagroup.javacapstoneapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class OccupationalHealthAndSafetyActivity extends AppCompatActivity implements View.OnClickListener {

    TextView ohsActAndCodeLink, safetyRightsLink, clickedLink;
    WebView browser;
    Button closeBrowser, goBack, goForward;

    ConstraintLayout browserScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohs);

        //TO GO LINKS
        ohsActAndCodeLink = (TextView)findViewById(R.id.ohsActRegAndCodeLink);
        safetyRightsLink = (TextView)findViewById(R.id.safetyRightsLink);

        //BROWSER
        browser = (WebView)findViewById(R.id.webView);
        browserScreen = (ConstraintLayout)findViewById(R.id.browserScreen);

        //BROWSER BUTTONS & TEXT
        closeBrowser = (Button)findViewById((R.id.btn_closebrowser));
        goBack = (Button)findViewById(R.id.btn_back);
        goForward = (Button)findViewById(R.id.btn_forward);
        clickedLink = (TextView)findViewById(R.id.txtview_url);

        //ON CLICKS EVENTS
        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);
        browser.setOnClickListener(this);
        closeBrowser.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);

    }

    private void openingLink(String url){
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(url);
        clickedLink.setText(browser.getUrl().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                //LINKS BUTTONS
            case R.id.ohsActRegAndCodeLink:
                openingLink ("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                browserScreen.setVisibility(View.VISIBLE);
                break;
            case R.id.safetyRightsLink:
                openingLink ("https://workershealthcentre.ca/4-health-and-safety-rights/");
                browserScreen.setVisibility(View.VISIBLE);
                break;
                //BROWSER BUTTONS
            case R.id.btn_closebrowser:
                browserScreen.setVisibility(View.INVISIBLE);
                break;
            case R.id.btn_back:
                if (browser.canGoBack()) {
                    browser.goBack();
                }
                break;
            case R.id.btn_forward:
                if(browser.canGoForward()){
                    browser.goForward();
                }
                break;
        }
    }

    @Override
    public void onBackPressed(){
        if(browser.canGoBack()){
            browser.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
