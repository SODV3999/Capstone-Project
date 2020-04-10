package com.javagroup.javacapstoneapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class FirebaseOperations {

    static DatabaseReference strings() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("strings");
        myRef.keepSynced(true);

        return myRef;
    }

}
