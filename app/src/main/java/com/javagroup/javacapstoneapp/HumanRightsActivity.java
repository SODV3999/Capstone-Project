package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class HumanRightsActivity extends AppCompatActivity implements View.OnClickListener {

    WebView browser;
    Button closeBrowser, goBack, goForward;
    TextView clickedLink;

    ConstraintLayout browserScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_rights);
        TextView humanRightsAct = (TextView) findViewById(R.id.link_humanRightsAct);
        //text.setMovementMethod(LinkMovementMethod.getInstance()); //REMOVED by Victor

        TextView humanRightComplaintProcess= (TextView) findViewById(R.id.link_humanRightsProcess);
        //t.setMovementMethod(LinkMovementMethod.getInstance()); //REMOVED by Victor

        //embedded browser
        browser = (WebView)findViewById(R.id.webView);
        browserScreen = (ConstraintLayout)findViewById(R.id.browserScreen);

        //Browser buttons and text
        closeBrowser = (Button)findViewById((R.id.btn_closebrowser));
        goBack = (Button)findViewById(R.id.btn_back);
        goForward = (Button)findViewById(R.id.btn_forward);
        clickedLink = (TextView)findViewById(R.id.txtview_url);

        //On click events
        humanRightsAct.setOnClickListener(this);
        humanRightComplaintProcess.setOnClickListener(this);
        closeBrowser.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);
    }

    private void openingLink(String url){
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewController());
        browser.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        clickedLink.setText("Loading. Please Wait!");
    }

    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            clickedLink.setText("Loading. Please Wait!" );
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

    }

    private void browserAppearance(){
        browserScreen.setVisibility(View.VISIBLE);
        browserScreen.setTranslationY(3000);
        browserScreen.animate().translationYBy(-3000).setDuration(1500);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
                //Opening links
            case R.id.link_humanRightsAct:
                openingLink("http://www.qp.alberta.ca/documents/Acts/A25P5.pdf");
                browserAppearance();
                break;
            case R.id.link_humanRightsProcess:
                openingLink("https://www.albertahumanrights.ab.ca/Documents/GuideProcess_Complainants.pdf");
                browserAppearance();
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
