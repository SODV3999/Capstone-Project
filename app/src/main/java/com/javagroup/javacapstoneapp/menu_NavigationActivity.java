package com.javagroup.javacapstoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/*WRITTEN BY : Victor Charl Corpuz*/
public class menu_NavigationActivity extends Fragment implements View.OnClickListener {

    private ConstraintLayout navigationScreen;
    private static final String TAG = "NavigationActivity";
    private DatabaseReference stringsRef = FirebaseOperations.strings();
    private TextView openHome,
            openFindingYourVoice,
            openWorkplaceSafety,
            openEmploymentStandards,
            openHumanRights,
            openOHS,
            openResources,
            openFund,
            openDisclaimer;

    Intent selectedMenu;

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

        openHome = showNav.findViewById(R.id.btn_home);
        openFindingYourVoice = showNav.findViewById(R.id.btn_finding_your_voice);
        openWorkplaceSafety = showNav.findViewById(R.id.btn_know_your_rights);
        openEmploymentStandards = showNav.findViewById(R.id.btn_es);
        openHumanRights = showNav.findViewById(R.id.btn_hr);
        openOHS = showNav.findViewById(R.id.btn_ohs);
        openResources = showNav.findViewById(R.id.btn_resources);
        openFund = showNav.findViewById(R.id.btn_fund);
        openDisclaimer = showNav.findViewById(R.id.btn_disclaimer);

        openHome.setOnClickListener(this);
        openFindingYourVoice.setOnClickListener(this);
        openWorkplaceSafety.setOnClickListener(this);
        openEmploymentStandards.setOnClickListener(this);
        openHumanRights.setOnClickListener(this);
        openOHS.setOnClickListener(this);
        openResources.setOnClickListener(this);
        openFund.setOnClickListener(this);
        openDisclaimer.setOnClickListener(this);

        return showNav;
    }

    private void getMenuFromDatabase(View showNav) {

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

                openHome.setText(homeTxt);
                openFindingYourVoice.setText(findYourVoiceTxt);
                openWorkplaceSafety.setText(knowYourRightsTxt);
                openEmploymentStandards.setText(eSTxt);
                openHumanRights.setText(hRTxt);
                openOHS.setText(oHSTxt);
                openResources.setText(resourcesTxt);
                openFund.setText(fundTxt);
                openDisclaimer.setText(disclaimerTxt);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

    /*Written by: Victor Charl*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home:
            case R.id.btn_know_your_rights:
                openActivity(MainActivity.class, 0);
                break;
            case R.id.btn_finding_your_voice:
                openActivity(MainActivity.class, 1);
                break;
            case R.id.btn_es:
                Toast.makeText(getActivity(), "REVIEW THE LAYOUT FIRST", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_hr:
                Toast.makeText(getActivity(), "REVIEW THE LAYOUT FIRST", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_ohs:
                Toast.makeText(getActivity(), "REVIEW THE LAYOUT FIRST", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_resources:
                openActivity(MainActivity.class, 2);
                break;
            case R.id.btn_fund:
                Toast.makeText(getActivity(), "REVIEW THE LAYOUT FIRST", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_disclaimer:
                Toast.makeText(getActivity(), "REVIEW THE LAYOUT FIRST", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void openActivity(Class classActivity, int pos){
        selectedMenu = new Intent(getActivity(), classActivity);
        selectedMenu.putExtra("position", pos);
        startActivity(selectedMenu);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        getActivity().finish();
    }
}
