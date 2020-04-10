package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class menu_NavigationActivity extends Fragment {

    private ConstraintLayout navigationScreen;
    private static final String TAG = "NavigationActivity";
    private DatabaseReference stringsRef = FirebaseOperations.strings();
    private TextView home,
            findingYourVoice,
            knowYourRights,
            employmentStandard,
            humanRights,
            ohs,
            resources,
            funder,
            disclaimer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View showNav = inflater.inflate(
                R.layout.fragment_menu_navigation_drawer,
                container,
                false);

        Button closeNav = showNav.findViewById(R.id.nav_close_button);
        navigationScreen = showNav.findViewById(R.id.navigationScreen);

        closeNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationScreen.animate().translationYBy(-3000)
                        .translationXBy(-3000).setDuration(450);
            }
        });

        getMenuFromDatabase(showNav);

        return showNav;
    }

    private void getMenuFromDatabase(View showNav) {
        home = showNav.findViewById(R.id.btn_home);
        findingYourVoice = showNav.findViewById(R.id.btn_finding_your_voice);
        knowYourRights = showNav.findViewById(R.id.btn_know_your_rights);
        employmentStandard = showNav.findViewById(R.id.btn_es);
        humanRights = showNav.findViewById(R.id.btn_hr);
        ohs = showNav.findViewById(R.id.btn_ohs);
        resources = showNav.findViewById(R.id.btn_resources);
        funder = showNav.findViewById(R.id.btn_fund);
        disclaimer = showNav.findViewById(R.id.btn_disclaimer);

        // Read from the database
        stringsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String homeTxt = dataSnapshot.child("homeTxt").getValue(String.class);
                String findYourVoiceTxt = dataSnapshot
                                                .child("findYourVoiceTxt")
                                                .getValue(String.class);
                String knowYourRightsTxt = dataSnapshot
                                                .child("WorkplaceSafetyTxt")
                                                .getValue(String.class);
                String eSTxt = dataSnapshot.child("eSTxt").getValue(String.class);
                String hRTxt = dataSnapshot.child("hRTxt").getValue(String.class);
                String oHSTxt = dataSnapshot.child("oHSTxt").getValue(String.class);
                String resourcesTxt = dataSnapshot.child("resourcesTxt").getValue(String.class);
                String fundTxt = dataSnapshot.child("fundTxt").getValue(String.class);
                String disclaimerTxt = dataSnapshot.child("disclaimerTxt").getValue(String.class);

                home.setText(homeTxt);
                findingYourVoice.setText(findYourVoiceTxt);
                knowYourRights.setText(knowYourRightsTxt);
                employmentStandard.setText(eSTxt);
                humanRights.setText(hRTxt);
                ohs.setText(oHSTxt);
                resources.setText(resourcesTxt);
                funder.setText(fundTxt);
                disclaimer.setText(disclaimerTxt);

                Log.d(TAG, "value is: " + homeTxt);
                Log.d(TAG, "value is: " + findYourVoiceTxt);
                Log.d(TAG, "value is: " + knowYourRightsTxt);
                Log.d(TAG, "value is: " + eSTxt);
                Log.d(TAG, "value is: " + hRTxt);
                Log.d(TAG, "value is: " + oHSTxt);
                Log.d(TAG, "value is: " + resourcesTxt);
                Log.d(TAG, "value is: " + fundTxt);
                Log.d(TAG, "value is: " + disclaimerTxt);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }
}
