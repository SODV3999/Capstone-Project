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
public class SwipeOHSFragment extends Fragment {

    private TextView textView1,textView2;
    public SwipeOHSFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_swipe_o_h_s, container, false);
        textView1=view.findViewById(R.id.txt_label);
        //textView1.setText();
        textView2=view.findViewById(R.id.txt_display);
        String message = getArguments().getString("message");
        StringTokenizer tokens = new StringTokenizer(message,":");
        String first = tokens.nextToken();
        String second=tokens.nextToken();
        textView1.setText(second);
        textView2.setText(first);
        return view;
    }
}
