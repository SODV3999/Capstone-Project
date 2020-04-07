package com.javagroup.javacapstoneapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class FirebaseOperations {

    static DatabaseReference navigation() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("navigation");
        myRef.keepSynced(true);

        return myRef;
    }
}
