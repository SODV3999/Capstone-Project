package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class mainsection_FindingYourVoiceActivity extends AppCompatActivity {

    private BottomSheetBehavior bsbFindingYourVoice;
    private LinearLayout fyvLinearLayout;
    private ImageView slideUpDown;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsection_finding_your_voice);



    }



}
