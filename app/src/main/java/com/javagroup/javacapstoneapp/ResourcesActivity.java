package com.javagroup.javacapstoneapp;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
<<<<<<< HEAD
import androidx.fragment.app.FragmentTransaction;
=======
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class ResourcesActivity extends AppCompatActivity implements View.OnClickListener {

<<<<<<< HEAD
    private ConstraintLayout browserContainer;
=======
    private WebView browser;
    private Button closeBrowser, goBack, goForward;
    private TextView clickedLink;

    private ConstraintLayout browserScreen;
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

    private Button dial1, dial2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
<<<<<<< HEAD

        TextView healthCenterLink = (TextView) findViewById(R.id.txt_health_center);
        TextView resourceCenterLink = (TextView) findViewById(R.id.txt_Resource_Center);

        dial1 = (Button)findViewById(R.id.btn_dial1);
        dial2 = (Button)findViewById(R.id.btn_dial2);

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        healthCenterLink.setOnClickListener(this);
        resourceCenterLink.setOnClickListener(this);
    }

=======
        TextView healthCenterLink = (TextView) findViewById(R.id.txt_health_center);
        //text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView resourceCenterLink = (TextView) findViewById(R.id.txt_Resource_Center);
        //t.setMovementMethod(LinkMovementMethod.getInstance());

        dial1 = (Button)findViewById(R.id.btn_dial1);
        dial2 = (Button)findViewById(R.id.btn_dial2);

        //embedded browser
        browser = (WebView)findViewById(R.id.webView);
        browserScreen = (ConstraintLayout)findViewById(R.id.browserScreen);

        //Browser buttons and text
        closeBrowser = (Button)findViewById((R.id.btn_closebrowser));
        goBack = (Button)findViewById(R.id.btn_back);
        goForward = (Button)findViewById(R.id.btn_forward);
        clickedLink = (TextView)findViewById(R.id.txtview_url);

        //On click events
        healthCenterLink.setOnClickListener(this);
        resourceCenterLink.setOnClickListener(this);
        closeBrowser.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);
    }

>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
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
<<<<<<< HEAD
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

=======
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewController());
        browser.loadUrl(url);
        clickedLink.setText(url);
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
        dial1.setVisibility(View.INVISIBLE);
        dial2.setVisibility(View.INVISIBLE);
        browserScreen.setVisibility(View.VISIBLE);
        browserScreen.setTranslationY(3000);
        browserScreen.animate().translationYBy(-3000).setDuration(1500);
    }
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
<<<<<<< HEAD
            case R.id.txt_health_center:
                openingLink("https://www.workershealthcentre.ca/");
                break;
            case R.id.txt_Resource_Center:
                openingLink("https://www.helpwrc.org/");
=======
            //BROWSER BUTTONS
            case R.id.btn_closebrowser:
                dial1.setVisibility(View.VISIBLE);
                dial2.setVisibility(View.VISIBLE);
                browserScreen.animate().translationYBy(3000).setDuration(1500);
                break;
            case R.id.btn_back:
                browser.goBack();
                break;
            case R.id.btn_forward:
                browser.goForward();
                break;
            //Opening Links
            case R.id.txt_health_center:
                openingLink("https://www.workershealthcentre.ca/");
                browserAppearance();
                break;
            case R.id.txt_Resource_Center:
                openingLink("https://www.helpwrc.org/");
                browserAppearance();
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
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
