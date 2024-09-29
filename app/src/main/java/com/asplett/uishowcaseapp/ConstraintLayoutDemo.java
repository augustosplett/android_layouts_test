package com.asplett.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import android.widget.Toast;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ConstraintLayoutDemo extends Fragment {

    private ProgressBar progressBar;
    private SwitchCompat switchToggle;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.constraint_layout_demo, container, false);

        switchToggle = rootView.findViewById(R.id.switch_toggle);
        switchToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String state = isChecked ? "On" : "Off";
            Toast.makeText(getActivity(), "Switch is " + state, Toast.LENGTH_SHORT).show();
        });

        progressBar = rootView.findViewById(R.id.progress_bar);

        fab = rootView.findViewById(R.id.fab_action);
        fab.setOnClickListener(v -> {
            Snackbar.make(rootView, "FAB Clicked!", Snackbar.LENGTH_LONG).show();
        });

        return rootView;
    }
}
