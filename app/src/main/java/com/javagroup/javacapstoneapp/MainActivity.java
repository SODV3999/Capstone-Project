package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



public class MainActivity extends AppCompatActivity {

    private ConstraintLayout navigationScreen;
    ImageButton openNav;

//    public void changeActivity(){
//        Log.d("changeActivity: ", "Clicked");
//        Intent intent = new Intent(this, Funders.class);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationScreen = findViewById(R.id.navigationScreen);
        openNav = findViewById(R.id.openNav);



        // TODO: Research on how to use and implement threads properly
        openNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread navThread = new Thread() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                navigationScreen.setTranslationY(-3000);
                                navigationScreen.setTranslationX(-3000);
                                navigationScreen.animate().translationYBy(3000)
                                        .translationXBy(3000).setDuration(450);
                                final FragmentTransaction openTheBrowser =
                                        getSupportFragmentManager().beginTransaction();
                                final menu_NavigationActivity menuNavigationActivity =
                                        new menu_NavigationActivity();
                                openTheBrowser.add(R.id.navigationScreen, menuNavigationActivity);
                                openTheBrowser.commit();
                            }
                        });
                    }
                };
                navThread.start();
            }
        });

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(
                new ViewPagerAdapter(getSupportFragmentManager(),
                3,
                3));
    }

    public void launchOccupationalHealthAndSafety(View view) {
        startActivity(new Intent(this, old_OccupationalHealthAndSafetyActivity.class));
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
        startActivity(new Intent(this, subsection_Resources_DisclaimerActivity.class));
    }
}
