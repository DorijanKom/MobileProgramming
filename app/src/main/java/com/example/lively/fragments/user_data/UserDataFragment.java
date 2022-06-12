package com.example.lively.fragments.user_data;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.R;
import com.example.lively.database.LivelyDatabase;
import com.example.lively.database.tables.Users;

import java.util.List;
import java.util.WeakHashMap;


public class UserDataFragment extends Fragment {

    private Users user;
    private Button saveButton;
    private EditText height, weight, age;
    private Spinner gender;

    public UserDataFragment() {
        user = new Users();
    }

    public UserDataFragment(Users user) {
        this.user = user;
    }

    private List<Users> usersList = LivelyDatabase.getDatabase(getContext()).usersDAO().getAllUsers();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userdata, container, false);

        saveButton = view.findViewById(R.id.btnSaveUser);
        height = view.findViewById(R.id.height_text);
        weight = view.findViewById(R.id.weight_text);
        age = view.findViewById(R.id.age_text);
        gender = view.findViewById(R.id.select_gender);

        if (height.getText().toString().isEmpty() || weight.getText().toString().isEmpty() || age.getText().toString().isEmpty() || gender.getSelectedItem().toString().isEmpty()) {
            Toast.makeText(getContext(), "Error!", Toast.LENGTH_LONG).show();
            saveButton.setEnabled(false);

        }else{
            Toast.makeText(getContext(), "Saved!", Toast.LENGTH_LONG).show();
            saveButton.setEnabled(true);

        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setGender(gender.getSelectedItem().toString());
                user.setAge(Integer.parseInt(age.getText().toString()));
                user.setHeight(Double.parseDouble(height.getText().toString()));
                user.setWeight(Double.parseDouble(weight.getText().toString()));

                LivelyDatabase.getDatabase(getContext()).usersDAO().updateUsers(user);

                Toast.makeText(getContext(), "User updated!", Toast.LENGTH_LONG).show();
            }
        });





        return view;
    }

}
