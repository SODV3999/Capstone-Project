package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class old_OccupationalHealthAndSafetyActivity extends
        AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout browserContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_ohs);

        TextView ohsActAndCodeLink = (TextView) findViewById(R.id.ohsActRegAndCodeLink);
        TextView safetyRightsLink = (TextView) findViewById(R.id.safetyRightsLink);

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);

        Intent intent = getIntent();


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
        switch (v.getId()){
                //LINKS BUTTONS
            case R.id.ohsActRegAndCodeLink:
                openingLink("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                break;
            case R.id.safetyRightsLink:
                openingLink("https://workershealthcentre.ca/4-health-and-safety-rights/");
                break;
        }
    }
}
