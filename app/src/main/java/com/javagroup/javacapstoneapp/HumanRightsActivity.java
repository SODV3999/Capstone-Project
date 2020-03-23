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

public class HumanRightsActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView browser;
    private Button closeBrowser, goBack, goForward;
    private TextView clickedLink;

    private ConstraintLayout browserContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_rights);

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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                //Opening pdf file
            case R.id.link_humanRightsAct:
                openingPDF("http://www.qp.alberta.ca/documents/Acts/A25P5.pdf");
                break;
            case R.id.link_humanRightsProcess:
                openingPDF("https://www.albertahumanrights.ab.ca/Documents/GuideProcess_Complainants.pdf");
                break;
        }
    }
}
