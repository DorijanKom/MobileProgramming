package com.example.lively.fragments.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.R;
import com.example.lively.fragments.home.HomeFragment;
import com.example.lively.fragments.schedule.ScheduleFragment;

public class ExerciseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        Button set_schedule = view.findViewById(R.id.btnSchedule);


        set_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getParentFragmentManager().beginTransaction().replace(R.id.frag_container_view, new ScheduleFragment()).commit();

            }
        });


















        return view;



    }



}



