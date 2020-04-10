package com.javagroup.javacapstoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class old_EmploymentStandardsActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final String TAG = "esActivity";
    private DatabaseReference stringsRef = FirebaseOperations.strings();
    private TextView employmentStandardsIntro, employmentStandardsDescription;

    private ConstraintLayout browserContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_es);

        TextView humanRightsActLink = (TextView) findViewById(R.id.link_humanRightsAct);
        TextView employmentCodeLink = (TextView) findViewById(R.id.employmentcode);
        TextView employmentRegulationsLink = (TextView) findViewById(R.id.EmploymentRegulations);

        employmentStandardsIntro = findViewById(R.id.es_intro);
        employmentStandardsDescription = findViewById(R.id.es_description);
        getEmploymentStandardsStrings();
        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);

        humanRightsActLink.setOnClickListener(this);
        employmentCodeLink.setOnClickListener(this);
        employmentRegulationsLink.setOnClickListener(this);

        Intent intent = getIntent();

    }

    private void getEmploymentStandardsStrings() {
        stringsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String introduction = dataSnapshot
                                            .child("employmentStandardsIntro")
                                            .getValue(String.class);
                String description = dataSnapshot
                                            .child("employmentStandardsDescription")
                                            .getValue(String.class);

                employmentStandardsIntro.setText(introduction);
                employmentStandardsDescription.setText(description);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

    private void openingPdf(String pdf){
        browserContainer.setTranslationY(3000);
        browserContainer.animate().translationYBy(-3000).setDuration(700);
        final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
        final WebBrowserActivity webBrowserActivity = new WebBrowserActivity();
        Bundle link = new Bundle();
        link.putString("url", "https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
        webBrowserActivity.setArguments(link);
        openTheBrowser.add(R.id.browserContainer, webBrowserActivity);
        openTheBrowser.commit();
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
        switch (v.getId()) {
            //Opening link
            case R.id.link_humanRightsAct:
                openingLink("https://www.alberta.ca/alberta-employment-standards-rules.aspx");
                break;
            //Opening pdf file
            case R.id.employmentcode:
                openingPdf("http://www.qp.alberta.ca/documents/Acts/E09.pdf");
                break;
            case R.id.EmploymentRegulations:
                openingPdf("http://www.qp.alberta.ca/documents/Regs/1997_014.pdf");
                break;
        }
    }
}
