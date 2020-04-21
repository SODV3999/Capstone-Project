package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

public class subsection_WorkplaceSafety_EmploymentStandards extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout browserContainer;

    private TextView link_es_rules, link_es_acts, link_es_regulations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsection_workplacesafety_employmentstandards);

        browserContainer = findViewById(R.id.browserContainer);

        link_es_rules = findViewById(R.id.link_es_rules);
        link_es_acts = findViewById(R.id.link_es_acts);
        link_es_regulations = findViewById(R.id.link_es_regulations);

        link_es_regulations.setOnClickListener(this);
        link_es_rules.setOnClickListener(this);
        link_es_acts.setOnClickListener(this);
    }

    private void openingLink(String url){
        browserContainer.setTranslationY(3000);
        browserContainer.animate().translationYBy(-3000).setDuration(700);
        final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
        final WebBrowserActivity webBrowserActivity = new WebBrowserActivity();
        Bundle link = new Bundle();
        link.putString("url", url);
        webBrowserActivity.setArguments(link);
        openTheBrowser.replace(R.id.browserContainer, webBrowserActivity);
        openTheBrowser.commit();
    }

    private void openingPdf(String pdf){
        browserContainer.setTranslationY(3000);
        browserContainer.animate().translationYBy(-3000).setDuration(700);
        final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
        final WebBrowserActivity webBrowserActivity = new WebBrowserActivity();
        Bundle link = new Bundle();
        link.putString("url", "https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
        webBrowserActivity.setArguments(link);
        openTheBrowser.replace(R.id.browserContainer, webBrowserActivity);
        openTheBrowser.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.link_es_rules:
                openingLink("https://www.alberta.ca/alberta-employment-standards-rules.aspx");
                break;
            case  R.id.link_es_regulations:
                openingPdf("http://www.qp.alberta.ca/documents/Regs/1997_014.pdf");
                break;
            case R.id.link_es_acts:
                openingPdf("http://www.qp.alberta.ca/documents/Acts/E09.pdf");
        }
    }
}
