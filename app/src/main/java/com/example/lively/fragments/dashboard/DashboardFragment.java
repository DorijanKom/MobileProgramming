package com.example.lively.fragments.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.MainActivity;
import com.example.lively.R;
import com.example.lively.database.tables.Users;

import java.util.Date;

public class DashboardFragment extends Fragment {

    private TextView nextExercise;
    private TextView nextMeal;
    private TextView bmi;
    private TextView waterIntake;
    private TextView sleepIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        nextExercise = view.findViewById(R.id.exerciseDate);
        nextMeal = view.findViewById(R.id.mealTime);
        bmi = view.findViewById(R.id.bmi);
        waterIntake = view.findViewById(R.id.waterTime);
        sleepIn = view.findViewById(R.id.sleepInTime);

        Users user = ((MainActivity) getActivity()).user;

        nextExercise.setText(user.getNextMeal());
        nextMeal.setText(user.getNextMeal());
        bmi.setText(user.getBmi().toString());
        waterIntake.setText(user.getWaterInterval());
        sleepIn.setText(user.getSleepIn());

        return view;
    }
}
