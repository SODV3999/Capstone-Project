package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

/*WRITTEN BY : Victor Charl Corpuz*/
public class WebBrowserActivity extends Fragment {

    private TextView currentUrl;
    private WebView browser;
    private Button goBack;
    private Button goForward;
    private ConstraintLayout browserScreen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View showBrowser = inflater.inflate(
                R.layout.fragment_browser,
                container,
                false);

        currentUrl = showBrowser.findViewById(R.id.url_container);
        browser = showBrowser.findViewById(R.id.webView);
        Button closeBrowser = showBrowser.findViewById(R.id.browser_close_btn);
        browserScreen = showBrowser.findViewById(R.id.browserScreen);
        goBack = showBrowser.findViewById(R.id.btn_back);
        goForward = showBrowser.findViewById(R.id.btn_forward);

        Bundle link = getArguments();
        openEmbeddedBrowser(link.getString("url"));

        closeBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browserScreen.animate().translationYBy(3000).setDuration(700);
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser.goBack();
            }
        });

        goForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser.goForward();
            }
        });

        return showBrowser;
    }

    private void openEmbeddedBrowser(String url){
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewController());
        browser.loadUrl(url);
    }

    private class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            currentUrl.setText("Loading. Please Wait!");
            return false;
        }

        public void onPageFinished(WebView view, String url) {
            currentUrl.setText(url);
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
}
