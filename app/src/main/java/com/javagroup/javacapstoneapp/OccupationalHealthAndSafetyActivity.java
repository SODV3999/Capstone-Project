package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
<<<<<<< HEAD
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OccupationalHealthAndSafetyActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout browserContainer;
=======
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class OccupationalHealthAndSafetyActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView ohsActAndCodeLink, safetyRightsLink, clickedLink;
    private WebView browser;
    private Button closeBrowser, goBack, goForward;

    private ConstraintLayout browserScreen;
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohs);
<<<<<<< HEAD

        TextView ohsActAndCodeLink = (TextView) findViewById(R.id.ohsActRegAndCodeLink);
        TextView safetyRightsLink = (TextView) findViewById(R.id.safetyRightsLink);

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);

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
=======

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
        closeBrowser.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);

    }

    private void openingLink(String url){
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewController());
        browser.loadUrl(url);
        clickedLink.setText("Loading. Please Wait!");
    }

    private class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            clickedLink.setText("Loading. Please Wait!");
            return false;
        }

        public void onPageFinished(WebView view, String url) {
            clickedLink.setText(browser.getUrl().toString());
            if(browser.canGoBack()){
                goBack.setEnabled(true);
            }
            else{
                goBack.setEnabled(false);
            }
            if(browser.canGoForward()){
                goForward.setEnabled(true);
            }
            else{
                goForward.setEnabled(false);
            }
        }

>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                //LINKS BUTTONS
            case R.id.ohsActRegAndCodeLink:
<<<<<<< HEAD
                openingLink("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                break;
            case R.id.safetyRightsLink:
                openingLink("https://workershealthcentre.ca/4-health-and-safety-rights/");
                break;
=======
                openingLink ("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                browserScreen.setVisibility(View.VISIBLE);
                browserScreen.setTranslationY(3000);
                browserScreen.animate().translationYBy(-3000).setDuration(1500);
                break;
            case R.id.safetyRightsLink:
                openingLink ("https://workershealthcentre.ca/4-health-and-safety-rights/");
                browserScreen.setVisibility(View.VISIBLE);
                browserScreen.setTranslationY(3000);
                browserScreen.animate().translationYBy(-3000).setDuration(1500);
                break;
                //BROWSER BUTTONS
            case R.id.btn_closebrowser:
                browserScreen.animate().translationYBy(3000).setDuration(1500);
                break;
            case R.id.btn_back:
                browser.goBack();
                break;
            case R.id.btn_forward:
                browser.goForward();
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
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
        }
    }
}
