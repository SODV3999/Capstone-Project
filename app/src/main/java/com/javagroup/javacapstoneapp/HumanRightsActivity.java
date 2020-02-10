package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class HumanRightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_rights);
        TextView text= (TextView) findViewById(R.id.textlink);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView t= (TextView) findViewById(R.id.human_rights_complainght);
        t.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
