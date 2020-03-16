package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView menuWorkPlaceSafety,
            menuHumanRights,
            menuEmploymentStandards,
            menuOHS,
            menuFindingYourVoice,
            menuResources,
            menuDisclaimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuWorkPlaceSafety = findViewById(R.id.menu_workplace_safety);
        menuWorkPlaceSafety.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_work_white_24dp, 0, 0, 0);
        menuWorkPlaceSafety.setPadding(10, 0, 0, 0);

        menuHumanRights = findViewById(R.id.menu_human_rights);
        menuHumanRights.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_group_white_24dp, 0, 0, 0);
        menuHumanRights.setPadding(10, 0, 0, 0);

        menuEmploymentStandards = findViewById(R.id.menu_employment_standards);
        menuEmploymentStandards.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_assessment_white_24dp, 0, 0, 0);
        menuEmploymentStandards.setPadding(10, 0, 0, 0);

        menuOHS = findViewById(R.id.menu_occupation_health_safety);
        menuOHS.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_note_add_white_24dp, 0, 0, 0);
        menuOHS.setPadding(10, 0, 0, 0);

        menuFindingYourVoice = findViewById(R.id.menu_finding_your_voice);
        menuFindingYourVoice.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_contact_phone_white_24dp, 0, 0, 0);
        menuFindingYourVoice.setPadding(10, 0, 0, 0);

        menuResources = findViewById(R.id.menu_resources);
        menuResources.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_note_add_white_24dp, 0, 0, 0);
        menuResources.setPadding(10, 0, 0, 0);

        menuDisclaimer = findViewById(R.id.menu_disclaimer);
        menuDisclaimer.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_warning_white_24dp, 0, 0, 0);
        menuDisclaimer.setPadding(10, 0, 0, 0);
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

}
