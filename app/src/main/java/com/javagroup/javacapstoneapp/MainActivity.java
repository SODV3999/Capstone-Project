package com.javagroup.javacapstoneapp;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    ImageButton openNav;
    TabLayout tabLayout;
    WebView webView;
    private ConstraintLayout navigationScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        /*WRITTEN BY: Victor Charl Corpuz*/
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

        tabLayout = findViewById(R.id.tab_layout);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(
                new ViewPagerAdapter(getSupportFragmentManager(),
                        3,
                        3));

        /*Written by: Victor Charl*/
        Bundle bundle = getIntent().getExtras();
        int viewPagerPage = 0;
        if (bundle != null) { //check if the bundle is not null and store it in viewPagerPage
            // variable
            viewPagerPage = bundle.getInt("position");
        }
        /*setting viewPagerPage
            by default setCurrentItem == 0*/
        viewPager.setCurrentItem(viewPagerPage);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    public void launchOccupationalHealthAndSafety(View view) {
        startActivity(new Intent(this,
                subsection_WorkplaceSafety_OHS.class));
    }

    public void launchEmploymentStandards(View view) {
        startActivity(new Intent(this, subsection_WorkplaceSafety_EmploymentStandards.class));
    }

    public void launchHumanRights(View view) {
        startActivity(new Intent(this, subsection_WorkplaceSafety_HumanRights.class));
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


    public void calling_one(View view)
    {
        makePhoneCall_1();
    }

    private void makePhoneCall_1() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial = "780-486-9009";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + dial));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall_1();
                makePhoneCall_2();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void makePhoneCall_2() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            // String dial ="tel:" +5879692301;
            //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            String dial = "403-264-8100";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + dial));
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

    public void alberta_emp_standards(View view) {
        String url = "https://www.alberta.ca/alberta-employment-standards-rules.aspx";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void alberta_act(View view) {
        String url = "http://www.qp.alberta.ca/documents/Acts/E09.pdf";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void emp_standard_regulation(View view) {
        String url = "http://www.qp.alberta.ca/documents/Regs/1997_014.pdf";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void hr_acts(View view) {
        String url = "http://www.qp.alberta.ca/documents/Acts/A25P5.pdf";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void hr_commission(View view) {
        String url = "https://www.albertahumanrights.ab.ca/Documents/GuideProcess_Complainants" +
                ".pdf)";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    /*WRITTEN BY : VICTOR CHARL CORPUZ*/
    @Override
    public void onBackPressed() {
        final Dialog confirmDialog = new Dialog(this);
        confirmDialog.setContentView(R.layout.fragment_confirming_exit);
        Button btn_yes = (Button) confirmDialog.findViewById(R.id.btn_yes);
        Button btn_no = (Button) confirmDialog.findViewById(R.id.btn_no);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog.dismiss();
            }
        });
        confirmDialog.setCancelable(false);
        confirmDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        confirmDialog.show();
    }

    public void collapseNavFromHere(View view) {
        switch (view.getId()) {
            case R.id.main_section_workplace_safety:
            case R.id.main_btm_sheet_finding_your_voice:
            case R.id.main_btm_sheet_resources:
            case R.id.btm_sheet_finding_your_voice:
            case R.id.btm_sheet_workplace_safety:
            case R.id.btm_sheet_resources:
            case R.id.btmsheet_content_resources:
            case R.id.bottomsheet_content_workplacesafety:
                navigationScreen.animate().translationYBy(-3000)
                        .translationXBy(-3000).setDuration(450);
                break;

        }

    }

}
