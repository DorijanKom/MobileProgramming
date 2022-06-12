package com.example.lively.fragments.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.MainActivity;
import com.example.lively.R;
import com.example.lively.database.LivelyDatabase;
import com.example.lively.database.tables.Users;
import com.example.lively.fragments.home.HomeFragment;
import com.example.lively.fragments.schedule.ScheduleFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExerciseFragment extends Fragment {
    List<Users> usersList = new ArrayList<>();

    EditText exerciseTime;
    TextView nextExercise;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        Button set_schedule = view.findViewById(R.id.btnSchedule);
        Button find_gym = view.findViewById(R.id.btnGym);

        // TO be removed.
        exerciseTime = view.findViewById(R.id.exercisedFor_text);
        nextExercise = view.findViewById(R.id.nextExercise_text);

        nextExercise.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date(((MainActivity) getActivity()).user.getNextExercise())));

        set_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getParentFragmentManager().beginTransaction().replace(R.id.frag_container_view, new ScheduleFragment()).commit();

            }
        });




















        return view;



    }



}



