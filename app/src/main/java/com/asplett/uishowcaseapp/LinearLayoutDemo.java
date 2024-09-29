package com.asplett.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LinearLayoutDemo extends Fragment {

    private LinearLayout page1;
    private EditText userInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.linear_layout_demo, container, false);

        page1 = view.findViewById(R.id.page1);
        userInput = view.findViewById(R.id.page1_edit_text);
        Button page1_button = view.findViewById(R.id.page1_button);

        page1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "hello, " + userInput.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
