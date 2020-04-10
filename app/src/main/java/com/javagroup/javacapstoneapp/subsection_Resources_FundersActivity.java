package com.javagroup.javacapstoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class subsection_Resources_FundersActivity extends AppCompatActivity
{
    private static final String TAG = "subsectionFunders";
    private DatabaseReference stringsRef = FirebaseOperations.strings();
    private TextView fundersContentOne, fundersContentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funders);

        fundersContentOne = findViewById(R.id.funders_content_one);
        fundersContentTwo = findViewById(R.id.funders_content_two);

        getFundersStrings();

        Intent intent = getIntent();


    }

    private void getFundersStrings() {
        stringsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String content = dataSnapshot.child("fundersContent").getValue(String.class);
                fundersContentOne.setText(content);
                fundersContentTwo.setText(content);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

}
