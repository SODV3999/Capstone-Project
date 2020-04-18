package com.javagroup.javacapstoneapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeOhsWorkplaceHazardFragment extends Fragment {

    private TextView textViewheading,textViewdescription,textViewdetail;
    public SwipeOhsWorkplaceHazardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_swipe_ohs_workplace_hazard, container, false);
        textViewheading=view.findViewById(R.id.expand2txtviewheader);
        textViewdescription=view.findViewById(R.id.expand2txtviewdescription);
        textViewdetail=view.findViewById(R.id.expand2txtviewdetail);
        String header = getArguments().getString("header");
//        String description = getArguments().getString("description");
//        String details = getArguments().getString("details");
//        StringTokenizer tokens = new StringTokenizer(message,":");
//        String first = tokens.nextToken();
//        String second=tokens.nextToken();
        textViewheading.setText(header);
//        textViewdescription.setText(description);
//        textViewdetail.setText(details);
        return view;
    }
}
