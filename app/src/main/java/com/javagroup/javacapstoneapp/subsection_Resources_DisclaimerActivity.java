package com.javagroup.javacapstoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class subsection_Resources_DisclaimerActivity extends AppCompatActivity
{
    private static final String TAG = "subsectionDisclaimer";
    private DatabaseReference stringsRef = FirebaseOperations.strings();
    private TextView disclaimerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        disclaimerContent = findViewById(R.id.disclaimer_content);
        getDisclaimerStrings();

        Intent intent = getIntent();
    }

    public void getDisclaimerStrings() {
        stringsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String content = dataSnapshot.child("disclaimerContent").getValue(String.class);
                disclaimerContent.setText(content);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

}
