package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class FyvBottomSheetDialog extends BottomSheetDialogFragment {


    RelativeLayout mlay1, mlay2,mlay3;
    LinearLayout mll1,mll2,mll3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fyv_view = inflater.inflate(R.layout.btm_sheet_finding_your_voice, null, false);


        mlay1 = (RelativeLayout) fyv_view.findViewById(R.id.lay1);
        mlay2 = (RelativeLayout) fyv_view.findViewById(R.id.lay2);
        mlay3 = (RelativeLayout) fyv_view.findViewById(R.id.lay3);

        Button b1 = fyv_view.findViewById(R.id.lay3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("@@@ clicked1");
            }
        });

        mlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              System.out.println("@@@ clicked1");
            }
        });

        mlay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return fyv_view;
    }
}
