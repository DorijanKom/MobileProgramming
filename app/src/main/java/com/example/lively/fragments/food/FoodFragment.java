package com.example.lively.fragments.food;

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
import com.example.lively.fragments.SetTime;

public class FoodFragment extends Fragment {

    EditText nextMeal;
    TextView currentBMI;
    EditText waterText;

    private FoodFragment foodFragment = this;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        Button waterInterval = view.findViewById(R.id.btnWaterInterval);
        Button mealTime = view.findViewById(R.id.btnMeal);

        nextMeal = view.findViewById(R.id.nextMeal_text);
        currentBMI = view.findViewById(R.id.bmi_text);
        waterText = view.findViewById(R.id.water_text);

        //nextMeal.setText(((MainActivity) getActivity()).user.getNextMeal());
        currentBMI.setText(((MainActivity) getActivity()).user.getBmi().toString());
        //waterText.setText(((MainActivity) getActivity()).user.getWaterInterval());


        mealTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime setMealTime = new SetTime("Sleep", foodFragment);
                setMealTime.show(getChildFragmentManager(), "SetSleepTime");
            }
        });

        return view;


    }

    public void setNextMeal(int time) {
        int conHours = time/ 3600;
        int conMinutes = (time % 3600) / 60;
        nextMeal.setText(conHours + ":" + conMinutes);
    }
}
