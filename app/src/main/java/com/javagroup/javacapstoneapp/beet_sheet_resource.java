package com.javagroup.javacapstoneapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class beet_sheet_resource extends AppCompatActivity{
    public Button button1,button2;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        button1=findViewById(R.id.funder);
        button2=findViewById(R.id.disclaimer);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(this,Funders.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this,Disclaimer.class);
        startActivity(intent);
    }
}
