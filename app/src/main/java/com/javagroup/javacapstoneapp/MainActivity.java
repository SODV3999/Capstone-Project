package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;



public class MainActivity extends AppCompatActivity {

    private ConstraintLayout navigationScreen;
    ConstraintLayout bgResource;
    ImageButton openNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationScreen = (ConstraintLayout)findViewById(R.id.navigationScreen);
        openNav = (ImageButton)findViewById(R.id.openNav);

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
                                final NavigationActivity navigationActivity =
                                        new NavigationActivity();
                                openTheBrowser.add(R.id.navigationScreen, navigationActivity);
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
        viewPager.setPageTransformer(true, new ParallaxTransformer());
    }

    public void launchOccupationalHealthAndSafety(View view) {
        startActivity(new Intent(this, OccupationalHealthAndSafetyActivity.class));
    }

    public void launchEmploymentStandards(View view) {
        startActivity(new Intent(this, EmploymentStandardsActivity.class));
    }

    public void launchHumanRights(View view) {
        startActivity(new Intent(this, HumanRightsActivity.class));
    }
}
