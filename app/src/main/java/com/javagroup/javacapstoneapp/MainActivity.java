package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout navigationScreen;
    ImageButton openNav;
    private TextView workplaceSafety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationScreen = findViewById(R.id.navigationScreen);
        openNav = findViewById(R.id.openNav);

        // TODO: figure out how to set text programmatically
        View test = getLayoutInflater()
                .inflate(
                    R.layout.bottomsheetsheet_workplace_safety,
                    null,
                    false
                );
        workplaceSafety = test.findViewById(R.id.title_WorkplaceSafety);
        String s = "Hello World";
        workplaceSafety.setText(s);
        Log.d("testTag", "string is: " + workplaceSafety.getText());

        openNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationScreen.setTranslationY(-3000);
                navigationScreen.setTranslationX(-3000);
                navigationScreen.animate().translationYBy(3000)
                        .translationXBy(3000).setDuration(450);
                final FragmentTransaction openTheBrowser =
                        getSupportFragmentManager().beginTransaction();
                final menu_NavigationActivity navigationActivity = new menu_NavigationActivity();
                openTheBrowser.add(R.id.navigationScreen, navigationActivity);
                openTheBrowser.commit();
                openNav.setClickable(false);
                openNav.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openNav.setClickable(true);
                    }
                }, 1000);
            }
        });

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(
                new ViewPagerAdapter(getSupportFragmentManager(),
                3,
                3));
    }

    public void launchOccupationalHealthAndSafety(View view) {
        startActivity(new Intent(this,
                old_OccupationalHealthAndSafetyActivity.class));
    }

    public void launchEmploymentStandards(View view) {
        startActivity(new Intent(this, old_EmploymentStandardsActivity.class));
    }

    public void launchHumanRights(View view) {
        startActivity(new Intent(this, old_HumanRightsActivity.class));
    }

    public void launchFunders(View view) {
        startActivity(new Intent(this, subsection_Resources_FundersActivity.class));
    }

    public void launchDisclaimers(View view) {
        startActivity(new Intent(this,
                subsection_Resources_DisclaimerActivity.class));
    }

    public void launchCaseStudy1(View view) {
        startActivity(new Intent(this,
               CaseStudy1.class));
    }

    public void launchCaseStudy2(View view) {
        startActivity(new Intent(this,
                CaseStudy2.class));
    }

    public void launchCaseStudy3(View view) {
        startActivity(new Intent(this,
                CaseStudy3.class));
    }
}
