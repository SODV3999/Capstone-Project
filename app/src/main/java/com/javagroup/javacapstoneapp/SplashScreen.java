package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView logo;
    TextView school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = (ImageView) findViewById(R.id.imageView);
        school = (TextView) findViewById(R.id.school_text);

        performSplashScreen();

    }

    public void performSplashScreen() {

        logo.animate().alpha(1.0f).setDuration(1000);
        logo.animate().translationY(-200).setDuration(1500);
        school.animate().alpha(1.0f).setDuration(1000);
        school.animate().translationY(-300).setDuration(2500);

        Thread th = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showDisclaimerDialog();
                        }
                    });
                }
            }
        };
        th.start();
    }

    public void showDisclaimerDialog() {
        final Dialog disclaimerDialog = new Dialog(this);
        disclaimerDialog.setContentView(R.layout.dialog_disclaimer);
        Button btn_agree = (Button) disclaimerDialog.findViewById(R.id.btn_agree);
        ImageButton btn_close = (ImageButton) disclaimerDialog.findViewById(R.id.btn_close);
        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMainActivity = new Intent(
                        SplashScreen.this,
                        MainActivity.class);
                startActivity(openMainActivity);
                finish();
                disclaimerDialog.dismiss();
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        disclaimerDialog.setCancelable(false);
        disclaimerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        disclaimerDialog.show();
    }
}
