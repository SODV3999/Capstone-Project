package com.javagroup.javacapstoneapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int pageSectionNumber;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, int pageSectionNumber) {
        super(fm, behavior);
        this.pageSectionNumber = pageSectionNumber;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
     FragmentMain mainFragment = new FragmentMain();
     switch (position) {
         case 0:
             mainFragment.mainResource = R.layout.activity_mainsection_workplace_safety;
             break;
         case 1:
             mainFragment.mainResource = R.layout.activity_mainsection_finding_your_voice;
             break;
         case 2:
             mainFragment.mainResource = R.layout.activity_mainsection_resources;
             break;
         default:
             break;

     }
     return mainFragment;
    }

    @Override
    public int getCount() {
        return pageSectionNumber;
    }
}
