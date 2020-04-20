package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

public class subsection_WorkplaceSafety_HumanRights extends AppCompatActivity implements View.OnClickListener {

    private TextView link_hr_acts, link_hr_commission;

    private ConstraintLayout browserContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsection_workplacesafety_humanrights);

        browserContainer = findViewById(R.id.browserContainer);

        link_hr_acts = findViewById(R.id.link_hr_acts);
        link_hr_commission = findViewById(R.id.link_hr_commision);

        link_hr_acts.setOnClickListener(this);
        link_hr_commission.setOnClickListener(this);

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
        switch (v.getId())
        {
            case R.id.link_hr_acts:
                openingPdf("http://www.qp.alberta.ca/documents/Acts/A25P5.pdf");
            case R.id.link_hr_commision:
                openingPdf("https://www.albertahumanrights.ab.ca/Documents/GuideProcess_Complainants.pdf");

        }
    }
}
