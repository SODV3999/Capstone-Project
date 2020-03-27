package com.javagroup.javacapstoneapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class FindingYourVoiceActivity extends AppCompatActivity {

    private BottomSheetBehavior bsbFindingYourVoice;
    private LinearLayout fyvLinearLayout;
    private ImageView slideUpDown;
    FyvBottomSheetDialog fyvBottomSheetDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_your_voice);

        init();
        slideUpDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              bsbFindingYourVoice.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

    }

    private void init() {
        this.fyvLinearLayout = findViewById(R.id.btm_sheet_finding_your_voice);
        this.bsbFindingYourVoice = BottomSheetBehavior.from(fyvLinearLayout);
        this.slideUpDown = findViewById(R.id.slideUpDown);
        fyvBottomSheetDialog = new FyvBottomSheetDialog();

    }

}
