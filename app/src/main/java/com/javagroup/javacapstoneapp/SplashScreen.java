package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
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
=======

import android.content.Intent;
import android.os.Bundle;
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

<<<<<<< HEAD
    Boolean firstTime = true;

    ImageView logo;
=======
    ImageView logo;

>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266
    TextView school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

<<<<<<< HEAD
        logo = (ImageView) findViewById(R.id.imageView);
        school = (TextView) findViewById(R.id.school_text);

        if(firstTime){
            showDisclaimerDialog();
        }
        else{
        }

    }

    public void showDisclaimerDialog(){
        final Dialog disclaimerDialog = new Dialog(this);
        disclaimerDialog.setContentView(R.layout.dialog_disclaimer);
        Button btn_agree = (Button)disclaimerDialog.findViewById(R.id.btn_agree);
        ImageButton btn_close = (ImageButton) disclaimerDialog.findViewById(R.id.btn_close);
        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTime = false;
                performSplashScreen();
                disclaimerDialog.hide();
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

    public void performSplashScreen(){

        logo.animate().alpha(1.0f).setDuration(1000);
        logo.animate().translationY(-200).setDuration(1500);
        school.animate().alpha(1.0f).setDuration(1000);
        school.animate().translationY(-300).setDuration(2500);
=======
        logo = (ImageView)findViewById(R.id.imageView);
        school = (TextView)findViewById(R.id.school_text);

        logo.animate().translationY(-200).setDuration(1000);
        school.animate().alpha(1.0f).setDuration(1000);
        school.animate().translationY(-200).setDuration(2500);
>>>>>>> 12a4253ea02a6a38faacd5d736156a87c6e04266

        Thread th = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent mainActivity = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainActivity);
                    finish();
                }
            }
        };
        th.start();
    }
}
