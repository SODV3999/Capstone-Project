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
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1 ;
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

    public void calling_one(View view) {
        makePhoneCall_1();
   }

    private  void makePhoneCall_1()
    {


        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else
        {
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial ="780-486-9009";
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
                makePhoneCall_1();
                makePhoneCall_2();
            }else {
                Toast.makeText(this,"Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private  void makePhoneCall_2()
    {


        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else
        {
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial ="403-264-8100";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+dial));
            startActivity(intent);
        }
    }

    public void calling_two(View view) {
        makePhoneCall_2();
    }

    public void goToUrl_one(View view) {
        String url = "https://workershealthcentre.ca/";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void goToUrl_two(View view) {
        String url = "http://www.helpwrc.org/our-board/";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
