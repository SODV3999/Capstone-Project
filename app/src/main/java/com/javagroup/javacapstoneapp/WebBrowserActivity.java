package com.javagroup.javacapstoneapp;

import android.content.Intent;
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


public class WebBrowserActivity extends Fragment {

    private TextView clickedLink;
    private WebView browser;
    private Button goBack;
    private Button goForward;
    private ConstraintLayout browserScreen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View showBrowser = inflater.inflate(R.layout.fragment_browser, container, false);

        clickedLink = showBrowser.findViewById(R.id.txtview_url);
        browser = showBrowser.findViewById(R.id.webView);
        Button closeBrowser = showBrowser.findViewById(R.id.btn_closebrowser);
        browserScreen = showBrowser.findViewById(R.id.browserScreen);
        goBack = showBrowser.findViewById(R.id.btn_back);
        goForward = showBrowser.findViewById(R.id.btn_forward);

        Bundle link = getArguments();
        String url = link.getString("Link");
        openingLink(url);
        closeBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browserScreen.animate().translationYBy(3000).setDuration(1500);
            }
        });
        return showBrowser;
    }

    private void openingLink(String url){
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
}
