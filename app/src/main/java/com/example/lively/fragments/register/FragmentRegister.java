package com.example.lively.fragments.register;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lively.R;

public class FragmentRegister extends Fragment {


    Button btnRegister;
    EditText etUserName, etPassword, etEmail;
    String userName, email, pass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);
        etUserName = view.findViewById(R.id.etUserName);
        etPassword = view.findViewById(R.id.etPassword);
        etEmail = view.findViewById(R.id.etEmail);
        btnRegister.findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                userName =etUserName.getText().toString();
                email = etEmail.getText().toString();
                pass = etPassword.getText().toString();

                Toast.makeText(getContext(), "Registered", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
