package com.javagroup.javacapstoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1 ;
    private ConstraintLayout navigationScreen;
    ConstraintLayout bgResource;
    ImageButton openNav;

//    public void changeActivity(){
//        Log.d("changeActivity: ", "Clicked");
//        Intent intent = new Intent(this, Funders.class);
//    }

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


    public void launchFunders(View view) {
        Intent intent = new Intent(this, Funders.class);
        startActivity(intent);
    }

    public void launchDisclaimers(View view) {
        Intent intent = new Intent(this, Disclaimer.class);
        startActivity(intent);
    }

    public void calling_one(View view) {
       makePhoneCall();
    }

    private  void makePhoneCall()
    {


        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else
        {
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial ="5879692301";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+dial));
            startActivity(intent);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                makePhoneCall();
            }else {
                Toast.makeText(this,"Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void calling_two(View view) {
        makePhoneCall();
    }

    public void goToUrl_one(View view) {
        String url = "http://www.google.com";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void goToUrl_two(View view) {
        String url = "http://www.google.com";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
