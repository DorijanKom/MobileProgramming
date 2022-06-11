package com.example.lively.fragments.sleep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.MainActivity;
import com.example.lively.R;

public class SleepFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sleep, container, false);
        Button set_sleep = view.findViewById(R.id.set_sleep_button);
        long userID = ((MainActivity) getActivity()).userID;
        EditText sleptFor = view.findViewById(R.id.sleep_for_info);



        set_sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetSleepTime setSleepTime = new SetSleepTime();
                setSleepTime.show(getChildFragmentManager(), "SetSleepTime");
            }
        });

        sleptFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

}
