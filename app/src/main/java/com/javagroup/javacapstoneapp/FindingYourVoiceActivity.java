package com.javagroup.javacapstoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class FindingYourVoiceActivity extends AppCompatActivity {

    float x1,x2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_finding_your_voice);

    }

    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = motionEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = motionEvent.getX();
                if(x1 < x2){
                    Intent openFirstActivity = new Intent(FindingYourVoiceActivity.this, MainActivity.class);
                    startActivity(openFirstActivity);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    finish();
                }
                else if (x1>x2){
                    Intent openResourceActivity = new Intent(FindingYourVoiceActivity.this, ResourceAndDisclaimerActivity.class);
                    startActivity(openResourceActivity);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                }
                break;
        }
        return false;
    }

}
