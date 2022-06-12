package com.example.lively.fragments.sleep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.MainActivity;
import com.example.lively.R;
import com.example.lively.database.LivelyDatabase;
import com.example.lively.database.tables.Users;
import com.example.lively.fragments.SetTime;

import java.util.ArrayList;
import java.util.List;

public class SleepFragment extends Fragment {

    List<Users> usersList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sleep, container, false);
        Button set_sleep = view.findViewById(R.id.set_sleep_button);
        EditText sleptFor = view.findViewById(R.id.sleep_for_info);
        TextView sleepIN = view.findViewById(R.id.sleep_in_info);
        TextView avgSleep = view.findViewById(R.id.avg_sleep_info);
       Button saveButton = view.findViewById(R.id.sleep_for_info);


        List<Users> usersList = LivelyDatabase.getDatabase(getContext()).usersDAO().getAllUsers();

        set_sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime setSleepTime = new SetTime();
                setSleepTime.show(getChildFragmentManager(), "SetSleepTime");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sleptForEntered = sleptFor.toString();
                String[] splitSleptFor = sleptForEntered.split(":");
                int time = (Integer.parseInt(splitSleptFor[0])*3600+Integer.parseInt(splitSleptFor[1])*60);

            }
        });

        return view;
    }

  /*  public String returnSleepAverage(TextView sleepIn){
        Users users = LivelyDatabase.getDatabase(getContext()).usersDAO().getUsersBYID();
        String avgSleepString = sleepIn.toString();
        String[] split = avgSleepString.split(":\\s");
        int sleepAvg = Integer.parseInt(avgSleepString);

    }*/

}
