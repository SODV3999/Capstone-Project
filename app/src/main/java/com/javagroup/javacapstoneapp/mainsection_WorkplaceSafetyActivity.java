package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class mainsection_WorkplaceSafetyActivity extends AppCompatActivity {


    public BottomSheetBehavior behaviorFindingYourVoice, behaviorWorkplaceSafety, behaviorResources;
    private LinearLayout findingYourVoiceLinearLayout, workplaceSafetyLinearLayout, resourcesLinearLayout;
    public ImageView slideBtmSheetFindingYourVoice, slideBtmSheetWorkPlaceSafety, slideBtmSheetResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsection_workplace_safety);

        findingYourVoiceLinearLayout = findViewById(R.id.btm_sheet_finding_your_voice);
        workplaceSafetyLinearLayout = findViewById(R.id.btm_sheet_workplace_safety);
        resourcesLinearLayout = findViewById(R.id.btm_sheet_resources);

        slideBtmSheetFindingYourVoice = findViewById(R.id.slideUpDownFindingYourVoice);
        slideBtmSheetWorkPlaceSafety = findViewById(R.id.slideUpDownWorkPlaceSafety);
        slideBtmSheetResources = findViewById(R.id.slideUpDownResources);

        behaviorFindingYourVoice = BottomSheetBehavior.from(findingYourVoiceLinearLayout);
        behaviorWorkplaceSafety = BottomSheetBehavior.from(workplaceSafetyLinearLayout);
        behaviorResources = BottomSheetBehavior.from(resourcesLinearLayout);

        slideBtmSheetWorkPlaceSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkplaceSafetyBtmSheetDialog workplaceSafetyBtmSheet = new WorkplaceSafetyBtmSheetDialog();
                workplaceSafetyBtmSheet.show(getSupportFragmentManager(), "btm_sheet_workplace_safety");
            }
        });

    }
}
