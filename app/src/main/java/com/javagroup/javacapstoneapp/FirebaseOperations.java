package com.javagroup.javacapstoneapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class FirebaseOperations {
    static String str;

    static DatabaseReference navigation() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("navigation");
        myRef.keepSynced(true);

        return myRef;
    }

    static String getString() {
        DatabaseReference ref = FirebaseOperations.navigation();
        //Log.d("REF TEST", "getString: " + ref.getRef());
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                str = dataSnapshot.child("WorkplaceSafetyTxt").getValue(String.class);
                Log.d("STR TEST", "getString: " + str);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return str;
    }
}
