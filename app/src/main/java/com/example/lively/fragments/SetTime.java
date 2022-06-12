package com.example.lively.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.lively.R;

public class SetTime extends DialogFragment {

    private static final String TAG = "SetSleepTime";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_time,container,false);

        TimePicker timePicker = view.findViewById(R.id.frag_time_clock);
        TextView textView = view.findViewById(R.id.set_time_card_button);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sleepForEntered = timePicker.toString();
                String[] split = sleepForEntered.split(":\\s");

                    long time = (Integer.parseInt(split[0])*120+Integer.parseInt(split[1])*60);

            }
        });
        return view;
    }
}