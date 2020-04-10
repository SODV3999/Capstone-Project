package com.javagroup.javacapstoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class SplashScreen extends AppCompatActivity {

    ImageView logo;
    TextView school, disclaimerContent;

    private DatabaseReference stringsRef = FirebaseOperations.strings();
    private static final String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = (ImageView) findViewById(R.id.imageView);
        school = (TextView) findViewById(R.id.school_text);

        performSplashScreen();

    }

    public void performSplashScreen() {

        logo.animate().alpha(1.0f).setDuration(1000);
        logo.animate().translationY(-200).setDuration(1500);
        school.animate().alpha(1.0f).setDuration(1000);
        school.animate().translationY(-300).setDuration(2500);

        Thread th = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showDisclaimerDialog();
                        }
                    });
                }
            }
        };
        th.start();
    }

    public void showDisclaimerDialog() {
        final Dialog disclaimerDialog = new Dialog(this);
        disclaimerDialog.setContentView(R.layout.fragment_dialog_disclaimer);
        disclaimerContent = disclaimerDialog.findViewById(R.id.txt_context);
        getDisclaimerStrings();
        Button btn_agree = (Button) disclaimerDialog.findViewById(R.id.btn_agree);
        ImageButton btn_close = (ImageButton) disclaimerDialog.findViewById(R.id.btn_close);
        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMainActivity = new Intent(
                        SplashScreen.this,
                        MainActivity.class);
                startActivity(openMainActivity);
                finish();
                disclaimerDialog.dismiss();
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        disclaimerDialog.setCancelable(false);
        disclaimerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        disclaimerDialog.show();
    }

    private void getDisclaimerStrings() {
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
