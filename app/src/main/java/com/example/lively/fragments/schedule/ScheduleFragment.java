package com.example.lively.fragments.schedule;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.MainActivity;
import com.example.lively.R;
import com.example.lively.database.LivelyDatabase;
import com.example.lively.database.tables.Users;
import com.example.lively.fragments.exercise.ExerciseFragment;

import java.util.Calendar;

public class ScheduleFragment extends Fragment {

    private CalendarView calendar;
    private Button save, back;

    private Users user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_schedule, container, false);

        calendar = view.findViewById(R.id.calendarView);
        save = view.findViewById(R.id.btnSave);
        back = view.findViewById(R.id.btnBack);

        user = ((MainActivity)getActivity()).user;

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setNextExercise(calendar.getDate());
                LivelyDatabase.getDatabase(getContext()).usersDAO().updateUsers(user);
                navigate();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigate();
            }
        });

        return view;
    }

    private void navigate() {
        getParentFragmentManager().beginTransaction().replace(R.id.frag_container_view, new ExerciseFragment()).commit();
    }
}
