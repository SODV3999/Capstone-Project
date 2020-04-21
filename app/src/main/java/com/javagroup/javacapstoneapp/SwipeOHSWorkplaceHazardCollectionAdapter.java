package com.javagroup.javacapstoneapp;

import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeOHSWorkplaceHazardCollectionAdapter extends FragmentStatePagerAdapter {
    public SwipeOHSWorkplaceHazardCollectionAdapter( FragmentManager fm) {
        super(fm);
    }
    private int[] image_src = {R.drawable.physical_hazard_hdpi,
            R.drawable.chemical_hazard_hdpi,R.drawable.biological_hazard_hdpi,
            R.drawable.psychological_hazard_hdpi};
    @NonNull
    @Override
    public Fragment getItem(int position) {
        SwipeOhsWorkplaceHazardFragment swipeOhsWorkplaceHazardFragment= new SwipeOhsWorkplaceHazardFragment();
        Bundle bundle=new Bundle();
        position=position+1;
        if(position==1){
            bundle.putString("header","Pysical Hazard");
            bundle.putInt("image",image_src[0]);
            bundle.putString("description","Description of Hazard");
            bundle.putString("details","sjdhf sdfjsdh sdfjhkjsd kffjf sdfdsf sdfsdfekj efkjkehf dfjhjkhdf sfsdf");
        }
        if(position==2){
            bundle.putString("header","Chemical Hazards");
            bundle.putInt("image",image_src[1]);
            bundle.putString("description","Description of Hazard");
            bundle.putString("details","sjdhf sdfjsdh sdfjhkjsd kffjf sdfdsf sdfsdfekj efkjkehf dfjhjkhdf sfsdf");
        }
        if(position==3){
            bundle.putString("header","Biological Hazards");
            bundle.putInt("image",image_src[2]);
            bundle.putString("description","Description of Hazard");
            bundle.putString("details","sjdhf sdfjsdh sdfjhkjsd kffjf sdfdsf sdfsdfekj efkjkehf dfjhjkhdf sfsdf");
        }
        if(position==4){
            bundle.putString("header","Psychological Hazards");
            bundle.putInt("image",image_src[3]);
            bundle.putString("description","Description of Hazard");
            bundle.putString("details","sjdhf sdfjsdh sdfjhkjsd kffjf sdfdsf sdfsdfekj efkjkehf dfjhjkhdf sfsdf");
        }
        swipeOhsWorkplaceHazardFragment.setArguments(bundle);
        return swipeOhsWorkplaceHazardFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
