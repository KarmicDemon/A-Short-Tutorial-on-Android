package com.hackers.purdue.android_tutorial;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class God_Calculator_Fragment extends Fragment {
    Button calculate;
    EditText firstNumber;
    EditText secondNumber;
    Spinner options;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_god__calculator, container, false);

        calculate = (Button) view.findViewById(R.id.calculate_button);
        firstNumber = (EditText) view.findViewById(R.id.first_number_edit_text);
        secondNumber = (EditText) view.findViewById(R.id.second_number_edit_text);
        options = (Spinner) view.findViewById(R.id.func_options_spinner);
        answer = (TextView) view.findViewById(R.id.answer);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first_int = Integer.parseInt(firstNumber.getText().toString());
                int sec_int = Integer.parseInt(secondNumber.getText().toString());

                String spin_option = options.getSelectedItem().toString();
                int new_num = 0;

                if (spin_option.equals("Add")) new_num = first_int + sec_int;
                if (spin_option.equals("Subtract")) new_num = first_int - sec_int;
                if (spin_option.equals("Multiply")) new_num = first_int * sec_int;
                if (spin_option.equals("Power")) new_num = (int) Math.pow(first_int, sec_int);
                if (spin_option.equals("Divide")) new_num = first_int / sec_int;

                answer.setText(Integer.toString(new_num));
            }
        });

        return view;
    }
}

