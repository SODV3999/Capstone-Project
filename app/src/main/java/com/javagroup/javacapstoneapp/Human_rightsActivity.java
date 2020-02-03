package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Human_rightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.human_rights_activity_main);
        TextView text= (TextView) findViewById(R.id.textlink);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView t= (TextView) findViewById(R.id.human_rights_complainght);
        t.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
