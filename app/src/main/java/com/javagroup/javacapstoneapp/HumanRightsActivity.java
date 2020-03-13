package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
<<<<<<< HEAD
import androidx.fragment.app.FragmentTransaction;
=======
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

import android.content.res.Resources;
import android.os.Bundle;
<<<<<<< HEAD
=======
import android.util.Log;
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class HumanRightsActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView browser;
    private Button closeBrowser, goBack, goForward;
    private TextView clickedLink;

<<<<<<< HEAD
    private ConstraintLayout browserContainer;
=======
    private ConstraintLayout browserScreen;
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_rights);
<<<<<<< HEAD

        TextView humanRightsAct = (TextView) findViewById(R.id.link_humanRightsAct);
        TextView humanRightComplaintProcess= (TextView) findViewById(R.id.link_humanRightsProcess);

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        humanRightsAct.setOnClickListener(this);
        humanRightComplaintProcess.setOnClickListener(this);

    }

    private void openingPDF(String pdf){
        browserContainer.setTranslationY(3000);
        browserContainer.animate().translationYBy(-3000).setDuration(700);
        final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
        final WebBrowserActivity webBrowserActivity = new WebBrowserActivity();
        Bundle link = new Bundle();
        link.putString("url", "https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
        webBrowserActivity.setArguments(link);
        openTheBrowser.add(R.id.browserContainer, webBrowserActivity);
        openTheBrowser.commit();
    }

=======
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

    private void openingPdf(String url){
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        clickedLink.setText(url);
    }

    private void browserAppearance(){
        browserScreen.setVisibility(View.VISIBLE);
        browserScreen.setTranslationY(3000);
        browserScreen.animate().translationYBy(-3000).setDuration(1500);
    }

>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
<<<<<<< HEAD
                //Opening pdf file
            case R.id.link_humanRightsAct:
                openingPDF("http://www.qp.alberta.ca/documents/Acts/A25P5.pdf");
                break;
            case R.id.link_humanRightsProcess:
                openingPDF("https://www.albertahumanrights.ab.ca/Documents/GuideProcess_Complainants.pdf");
                break;
        }
=======
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
                //Opening pdf file
            case R.id.link_humanRightsAct:
                openingPdf("http://www.qp.alberta.ca/documents/Acts/A25P5.pdf");
                browserAppearance();
                break;
            case R.id.link_humanRightsProcess:
                openingPdf("https://www.albertahumanrights.ab.ca/Documents/GuideProcess_Complainants.pdf");
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
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
    }
}
