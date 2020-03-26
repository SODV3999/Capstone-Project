package com.javagroup.javacapstoneapp;

import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ParallaxTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page,  float position) {
        if (position >= -1 && position <= 1 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            try{
            page.findViewById(R.id.parallaxContent).setTransitionAlpha(-position * page.getWidth() / 2 );}
        catch (Exception e){
                e.printStackTrace();
        }
        else
            page.setAlpha(1);

    }
}
