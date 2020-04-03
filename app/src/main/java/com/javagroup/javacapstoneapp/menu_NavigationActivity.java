package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class menu_NavigationActivity extends Fragment {

    private ConstraintLayout navigationScreen;

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



        return showNav;
    }
}
