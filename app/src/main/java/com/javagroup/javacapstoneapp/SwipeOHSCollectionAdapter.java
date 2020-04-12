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
        bundle.putString("message","hello from page :"+position);
        swipeOHSFragment.setArguments(bundle);
        return swipeOHSFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
