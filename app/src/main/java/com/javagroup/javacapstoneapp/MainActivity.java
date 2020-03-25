package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{

    private ConstraintLayout navigationScreen;
    ImageButton openNav;

    private androidx.viewpager.widget.ViewPager viewPager;
    LinearLayout viewPagerIndicator;

    SlideAdapterActivity slideAdapterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerIndicator = (LinearLayout)findViewById(R.id.viewPageIndicator);

        slideAdapterActivity = new SlideAdapterActivity(this);
        viewPager.setAdapter(slideAdapterActivity);

        navigationScreen = (ConstraintLayout)findViewById(R.id.navigationScreen);
        openNav = (ImageButton )findViewById(R.id.openNav);

        openNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationScreen.setTranslationY(-3000);
                navigationScreen.setTranslationX(-3000);
                navigationScreen.animate().translationYBy(3000).translationXBy(3000).setDuration(100);
                final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
                final NavigationActivity navigationActivity = new NavigationActivity();
                openTheBrowser.add(R.id.navigationScreen, navigationActivity);
                openTheBrowser.commit();
            }
        });

    }

    public void navToSection1(View view) {
        Intent intent = new Intent(this, WorkplaceSafetyActivity.class);
        startActivity(intent);
    }

    public void navToSection2(View view) {
        Intent intent = new Intent(this, OccupationalHealthAndSafetyActivity.class);
        startActivity(intent);
    }

    public void navToSection3(View view) {
        Intent intent = new Intent(this, HumanRightsActivity.class);
        startActivity(intent);
    }

    public void navToSection4(View view) {
        Intent intent = new Intent(this, EmploymentStandardsActivity.class);
        startActivity(intent);
    }

    public void navToSection5(View view) {
        Intent intent = new Intent(this, NavigatingTheSystemActivity.class);
        startActivity(intent);
    }

    public void navToSection6(View view) {
        Intent intent = new Intent(this, ResourcesActivity.class);
        startActivity(intent);
    }
}
