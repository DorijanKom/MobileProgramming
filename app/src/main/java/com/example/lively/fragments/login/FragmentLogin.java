package com.example.lively.fragments.login;

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

public class FragmentLogin extends Fragment {

    Button btnLogin, btnRegister;
    EditText etUserName, etPassword;



    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                Toast.makeText(requireContext(), "LOGIN SUCCESSFUL!", Toast.LENGTH_SHORT).show();


            }
        });


        return view;


    }


}


