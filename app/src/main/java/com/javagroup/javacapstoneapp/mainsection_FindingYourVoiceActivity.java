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
    mainsection_FindingYourVoiceBottomSheet mainsectionFindingYourVoiceBottomSheet;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsection_finding_your_voice);

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
        this.slideUpDown = findViewById(R.id.slideUpDownFindingYourVoice);
        mainsectionFindingYourVoiceBottomSheet = new mainsection_FindingYourVoiceBottomSheet();

    }

}
