package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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

    private ConstraintLayout browserContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_es);

        TextView humanRightsActLink = (TextView) findViewById(R.id.link_humanRightsAct);
        TextView employmentCodeLink = (TextView) findViewById(R.id.employmentcode);
        TextView employmentRegulationsLink = (TextView) findViewById(R.id.EmploymentRegulations);

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        humanRightsActLink.setOnClickListener(this);
        employmentCodeLink.setOnClickListener(this);
        employmentRegulationsLink.setOnClickListener(this);
    }

    private void openingPdf(String pdf){
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //Opening link
            case R.id.link_humanRightsAct:
                openingLink("https://www.alberta.ca/alberta-employment-standards-rules.aspx");
                break;
            //Opening pdf file
            case R.id.employmentcode:
                openingPdf("http://www.qp.alberta.ca/documents/Acts/E09.pdf");
                break;
            case R.id.EmploymentRegulations:
                openingPdf("http://www.qp.alberta.ca/documents/Regs/1997_014.pdf");
                break;
        }
    }
}
