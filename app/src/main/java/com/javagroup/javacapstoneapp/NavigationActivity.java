package com.javagroup.javacapstoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class NavigationActivity extends Fragment implements View.OnClickListener {

    private ConstraintLayout navigationScreen;
    private TextView btn_home, btn_fyv, btn_kyr, btn_es, btn_hr, btn_ohs, btn_resources, btn_fund, btn_disclaimer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View showNav = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        Button closeNav = showNav.findViewById(R.id.nav_close_button);
        navigationScreen = showNav.findViewById(R.id.navigationScreen);

        closeNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationScreen.animate().translationYBy(-3000).setDuration(100);
                navigationScreen.animate().translationXBy(-3000).setDuration(100);
            }
        });

        btn_home = showNav.findViewById(R.id.btn_home);
        btn_fyv = showNav.findViewById(R.id.btn_finding_your_voice);
        btn_kyr = showNav.findViewById(R.id.btn_know_your_rights);
        btn_es = showNav.findViewById(R.id.btn_es);
        btn_hr = showNav.findViewById(R.id.btn_hr);
        btn_ohs = showNav.findViewById(R.id.btn_ohs);
        btn_resources = showNav.findViewById(R.id.btn_resources);
        btn_fund = showNav.findViewById(R.id.btn_fund);
        btn_disclaimer = showNav.findViewById(R.id.btn_disclaimer);

        btn_home.setOnClickListener(this);
        btn_fyv.setOnClickListener(this);
        btn_kyr.setOnClickListener(this);
        btn_es.setOnClickListener(this);
        btn_hr.setOnClickListener(this);
        btn_ohs.setOnClickListener(this);
        btn_resources.setOnClickListener(this);
        btn_fund.setOnClickListener(this);
        btn_disclaimer.setOnClickListener(this);

        return showNav;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home:
                break;
            case R.id.btn_finding_your_voice:
                break;
            case R.id.btn_know_your_rights:
                break;
            case R.id.btn_es:
                startActivity(new Intent (getActivity(), EmploymentStandardsActivity.class));
                break;
            case R.id.btn_hr:
                startActivity(new Intent (getActivity(), HumanRightsActivity.class));
                break;
            case R.id.btn_ohs:
                startActivity(new Intent (getActivity(), OccupationalHealthAndSafetyActivity.class));
                break;
            case R.id.btn_resources:
                startActivity(new Intent (getActivity(), ResourcesActivity.class));
                break;
            case R.id.btn_fund:
                break;
            case R.id.btn_disclaimer:
                break;
        }
    }
}
