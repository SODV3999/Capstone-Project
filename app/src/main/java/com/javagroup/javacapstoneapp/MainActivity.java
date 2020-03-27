package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
<<<<<<< HEAD
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class MainActivity extends AppCompatActivity {

    private ConstraintLayout navigationScreen;
    ImageButton openNav;

    float x1,x2,y1,y2;
=======
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
>>>>>>> 4753001def8f0a8114afe2b283a353dd40d8ba10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        navigationScreen = (ConstraintLayout)findViewById(R.id.navigationScreen);
        openNav = (ImageButton)findViewById(R.id.openNav);

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



        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), 3, 3));
        viewPager.setPageTransformer(true, new ParallaxTransformer());
    }



    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = motionEvent.getX();
                y1 = motionEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = motionEvent.getX();
                y2 = motionEvent.getY();
                if (x1>x2){
                    Intent openNextActivity = new Intent(MainActivity.this, FindingYourVoiceActivity.class);
                    startActivity(openNextActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    break;
                }
        }
        return false;

    }
=======
>>>>>>> 4753001def8f0a8114afe2b283a353dd40d8ba10

        button=findViewById(R.id.button_homeScreen);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity()
    {
        Intent intent = new Intent(this,HomeScreen.class);
        startActivity(intent);
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
        Intent intent = new Intent(this, resources.class);
        startActivity(intent);
    }
    public void navToSection7(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}
