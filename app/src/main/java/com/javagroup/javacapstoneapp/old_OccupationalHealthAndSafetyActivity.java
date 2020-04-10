package com.javagroup.javacapstoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class old_OccupationalHealthAndSafetyActivity extends
        AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ohsActivity";
    private ConstraintLayout browserContainer;
    private TextView ohsIntro;
    private DatabaseReference myStringRef = FirebaseOperations.strings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_ohs);

        ohsIntro = findViewById(R.id.ohs_intro);
        getOhsStrings();

        TextView ohsActAndCodeLink = (TextView) findViewById(R.id.ohsActRegAndCodeLink);
        TextView safetyRightsLink = (TextView) findViewById(R.id.safetyRightsLink);

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);

        Intent intent = getIntent();


    }

    private void getOhsStrings() {
        myStringRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String introduction = dataSnapshot.child("ohsIntro").getValue(String.class);
                ohsIntro.setText(introduction);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

    private void openingLink(String url){
        browserContainer.setTranslationY(3000);
        browserContainer.animate().translationYBy(-3000).setDuration(700);
        final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
        final WebBrowserActivity webBrowserActivity = new WebBrowserActivity();
        Bundle link = new Bundle();
        link.putString("url", url);
        webBrowserActivity.setArguments(link);
        openTheBrowser.add(R.id.browserContainer, webBrowserActivity);
        openTheBrowser.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                //LINKS BUTTONS
            case R.id.ohsActRegAndCodeLink:
                openingLink("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                break;
            case R.id.safetyRightsLink:
                openingLink("https://workershealthcentre.ca/4-health-and-safety-rights/");
                break;
        }
    }
}
