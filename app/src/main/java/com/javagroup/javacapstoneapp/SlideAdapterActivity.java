package com.javagroup.javacapstoneapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapterActivity extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    SlideAdapterActivity(Context context){
        this.context = context;
    }

    private int[] slide_background = {
            R.drawable.bg_fragment_1,
            R.drawable.bg_fragment_2,
            R.drawable.bg_fragment_3,
    };

    private String[] btn_text = {
            "Know your Rights and \n Workplace Safety",
            "Finding your Voice",
            "Resources, Funders \n and Disclaimer"
    };

    @Override
    public int getCount() {
        return btn_text.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_pager_layout, container, false);

        ConstraintLayout layout_bg = (ConstraintLayout)view.findViewById(R.id.layout_bg);
        Button btn_for_menu = (Button)view.findViewById(R.id.btn_for_menu);

        layout_bg.setBackgroundResource(slide_background[position]);
        btn_for_menu.setText(btn_text[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((ConstraintLayout)object);
    }
}
