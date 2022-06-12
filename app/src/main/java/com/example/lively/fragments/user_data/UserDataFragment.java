package com.example.lively.fragments.user_data;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.MainActivity;
import com.example.lively.R;
import com.example.lively.database.LivelyDatabase;
import com.example.lively.database.tables.Users;

import java.util.List;
import java.util.WeakHashMap;


public class UserDataFragment extends Fragment implements AdapterView.OnItemSelectedListener {

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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userdata, container, false);

        saveButton = view.findViewById(R.id.btnSaveUser);
        height = view.findViewById(R.id.height_text);
        weight = view.findViewById(R.id.weight_text);
        age = view.findViewById(R.id.age_text);
        //gender = view.findViewById(R.id.select_gender);

      /*  ArrayAdapter<Spinner> adapter = ArrayAdapter.createFromResource(getContext(),R.array.gender_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        gender.setOnItemClickListener(this);*/

        user.setAge(Integer.parseInt(age.getText().toString()));
        user.setHeight(Double.parseDouble(height.getText().toString()));
        user.setWeight(Double.parseDouble(weight.getText().toString()));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LivelyDatabase.getDatabase(getContext()).usersDAO().updateUsers(user);

                if (height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()
                        || age.getText().toString().isEmpty()
                        || gender.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Error!", Toast.LENGTH_LONG).show();
                    saveButton.setEnabled(false);

                }else{
                    Toast.makeText(getContext(), "Saved!", Toast.LENGTH_LONG).show();
                    saveButton.setEnabled(true);


                }
            }
        });





        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        if (text.equals("MALE")){
            user.calcCalories(Double.parseDouble(weight.getText().toString()),Double.parseDouble(height.getText().toString()),Integer.parseInt(age.getText().toString()),"MALE");
        }else{
            user.calcCalories(Double.parseDouble(weight.getText().toString()),Double.parseDouble(height.getText().toString()),Integer.parseInt(age.getText().toString()),"FEMALE");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
