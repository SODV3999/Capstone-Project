package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int pageSectionNumber;

    ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, int pageSectionNumber) {
        super(fm, behavior);
        this.pageSectionNumber = pageSectionNumber;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();

        // TODO: get string from firebase
        Log.d("TESTTAG", "getItem: " + FirebaseOperations.getString());
        switch (position) {
         case 0:
             mainFragment.mainResource = R.layout.activity_mainsection_workplace_safety;
             bundle.putString("test", "Workplace Safety");
             mainFragment.setArguments(bundle);
             break;
         case 1:
             mainFragment.mainResource = R.layout.activity_mainsection_finding_your_voice;
             bundle.putString("test1", "asdasdasd");
             mainFragment.setArguments(bundle);
             break;
         case 2:
             mainFragment.mainResource = R.layout.activity_mainsection_resources;
             bundle.putString("test2", "hello");
             mainFragment.setArguments(bundle);
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
