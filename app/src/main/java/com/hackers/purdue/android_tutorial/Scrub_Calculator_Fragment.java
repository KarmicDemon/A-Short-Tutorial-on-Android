package com.hackers.purdue.android_tutorial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Scrub_Calculator_Fragment extends Fragment {
    Button scrub_button;
    String wolf = "http://www.wolframalpha.com/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scrub__calculator, container, false);

        scrub_button = (Button) view.findViewById(R.id.to_wolf);
        scrub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri wolfram_alpha = Uri.parse(wolf);
                Intent intent = new Intent(Intent.ACTION_VIEW, wolfram_alpha);
                startActivity(intent);
            }
        });

        return view;
    }
}