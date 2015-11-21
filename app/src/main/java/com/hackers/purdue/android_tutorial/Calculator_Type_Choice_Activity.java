package com.hackers.purdue.android_tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Calculator_Type_Choice_Activity extends AppCompatActivity {
    Button god_button;
    Button scrub_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator__type__choice);
        getSupportActionBar().setTitle("Choose Calculator");

        god_button = (Button) findViewById(R.id.god_button);
        scrub_button = (Button) findViewById(R.id.scrub_button);

        god_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Calculator_Activity.class);
                i.putExtra("isGod", true);
                startActivity(i);
            }
        });

        scrub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Calculator_Activity.class);
                i.putExtra("isGod", false);
                startActivity(i);
            }
        });
    }
}
