package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    int mainResource;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(mainResource, container, false);

        if (view.findViewById(R.id.main_section_workplace_safety) != null) {
            TextView workplaceSafety = view.findViewById(R.id.title_WorkplaceSafety);
            String message = "";
            if (getArguments() != null) {
                message = getArguments().getString("test");
            }
            workplaceSafety.setText(message);
        } else if (view.findViewById(R.id.main_btm_sheet_finding_your_voice) != null) {
            TextView findYourVoice = view.findViewById(R.id.btm_sheet_title_finding_your_voice);
            String message = "";
            if (getArguments() != null) {
                message = getArguments().getString("test1");
            }
                findYourVoice.setText(message);
        } else if (view.findViewById(R.id.main_btm_sheet_resources) != null) {
            TextView resources = view.findViewById(R.id.btm_sheet_title_Resource);
            String message = "";
            Log.d("text", "onCreateView: " + getArguments());
            if (getArguments() != null) {
                message = getArguments().getString("test2");
            }
            resources.setText(message);
        }
        return view;
    }
}
