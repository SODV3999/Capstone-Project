package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class EmploymentStandardsActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView browser;
    private Button closeBrowser, goBack, goForward;
    private TextView clickedLink;

    private ConstraintLayout browserScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_es);
        TextView humanRightsActLink = (TextView) findViewById(R.id.link_humanRightsAct);
        //text.setMovementMethod(LinkMovementMethod.getInstance());
        TextView employmentCodeLink = (TextView) findViewById(R.id.employmentcode);
        //t.setMovementMethod(LinkMovementMethod.getInstance());
        TextView employmentRegulationsLink = (TextView) findViewById(R.id.EmploymentRegulations);
        //te.setMovementMethod(LinkMovementMethod.getInstance());

        //embedded browser
        browser = (WebView)findViewById(R.id.webView);
        browserScreen = (ConstraintLayout)findViewById(R.id.browserScreen);

        //Browser buttons and text
        closeBrowser = (Button)findViewById((R.id.btn_closebrowser));
        goBack = (Button)findViewById(R.id.btn_back);
        goForward = (Button)findViewById(R.id.btn_forward);
        clickedLink = (TextView)findViewById(R.id.txtview_url);

        //On click events
        humanRightsActLink.setOnClickListener(this);
        employmentCodeLink.setOnClickListener(this);
        employmentRegulationsLink.setOnClickListener(this);
        closeBrowser.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);
    }

    private void openingPdf(String url){
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        clickedLink.setText(url);
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
            //Opening link
            case R.id.link_humanRightsAct:
                openingLink("https://www.alberta.ca/alberta-employment-standards-rules.aspx");
                browserAppearance();
                break;
            //Opening pdf file
            case R.id.employmentcode:
                openingPdf("http://www.qp.alberta.ca/documents/Acts/E09.pdf");
                browserAppearance();
                break;
            case R.id.EmploymentRegulations:
                openingPdf("http://www.qp.alberta.ca/documents/Regs/1997_014.pdf");
                browserAppearance();
                break;
        }
    }
}
