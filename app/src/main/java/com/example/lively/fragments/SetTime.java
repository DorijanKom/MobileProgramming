package com.example.lively.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.lively.MainActivity;
import com.example.lively.R;
import com.example.lively.database.LivelyDatabase;
import com.example.lively.database.tables.Users;

public class SetTime extends DialogFragment {

    private static final String TAG = "SetSleepTime";
    private String fromPage;

    public SetTime(){

    }

    public SetTime(String fromPage){
        this.fromPage=fromPage;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_time,container,false);

        TimePicker timePicker = view.findViewById(R.id.frag_time_clock);
        TextView textView = view.findViewById(R.id.set_time_card_button);

        textView.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                int hours = timePicker.getCurrentHour();
                int minutes = timePicker.getCurrentMinute();
                TextView timeForSleep = view.findViewById(R.id.sleep_in_info);

                    int time = (hours*3600+minutes*60);
                    Users user = ((MainActivity) getActivity()).user;
                    switch (fromPage){
                        case "Sleep":

                            user.setSetSleeptime(time);
                            LivelyDatabase.getDatabase(getContext()).usersDAO().updateUsers(user);
                            int min_minuts = (user.getSetSleeptime() % 3600) / 60;
                            int min_hours = user.getSetSleeptime()/3600;
                            timeForSleep.setText(min_hours+":"+min_minuts);



                            break;
                        case "Food":
                            user.setNextMeal(time);
                            LivelyDatabase.getDatabase(getContext()).usersDAO().updateUsers(user);
                            int min_minutes1 = (user.getNextMeal() % 3600) / 60;
                            int min_hours1 = user.getNextMeal()/3600;
                            timeForSleep.setText(min_hours1+":"+min_minutes1);
                            break;
                        default:
                            break;
                    }
            }
        });
        return view;
    }
}
