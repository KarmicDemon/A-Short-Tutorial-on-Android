package com.hackers.purdue.android_tutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Calculator_Activity extends AppCompatActivity {
    boolean isGod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setTitle("Calculator");

        Bundle params = getIntent().getExtras();
        isGod = params.getBoolean("isGod");

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment f;

        if (isGod) f = new God_Calculator_Fragment();
        else f = new Scrub_Calculator_Fragment();

        Log.d("TAG", String.valueOf(isGod));

        ft.add(R.id.calculator_container_id, f);
        ft.commit();
    }
}
