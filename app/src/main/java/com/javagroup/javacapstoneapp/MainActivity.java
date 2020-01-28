package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.textlink);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t = (TextView) findViewById(R.id.employmentcode);
        t.setMovementMethod(LinkMovementMethod.getInstance());
        TextView te = (TextView) findViewById(R.id.EmploymentRegulations);
        te.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
