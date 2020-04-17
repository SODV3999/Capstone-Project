package com.javagroup.javacapstoneapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeOHSCollectionAdapter extends FragmentStatePagerAdapter {
    public SwipeOHSCollectionAdapter( FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        SwipeOHSFragment swipeOHSFragment= new SwipeOHSFragment();
        Bundle bundle=new Bundle();
        position=position+1;
       if(position==1){
           bundle.putString("message","Right to Know about the dangers of our jobs and how we are protected:"+position);
       }
       if(position==2){
            bundle.putString("message","Right to Participate in activities affecting our Health and Safety:"+position);
       }
       if(position==3){
           bundle.putString("message","Right to Refuse work we feel may be dangerous to ourselves" +
                   " or others:"+position);
       }
       if(position==4){
           bundle.putString("message","Right to Be Free from Reprisal(disciplined or fired) for using our Health and Safety rights:"+position);
       }
        swipeOHSFragment.setArguments(bundle);
        return swipeOHSFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
