package com.example.lively;

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

public class FragmentLogin extends Fragment {

    Button btnLogin, btnRegister;
    EditText etUserName, etPassword;
    String userName, pass;


    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        etUserName = view.findViewById(R.id.etUserName);
        etPassword = view.findViewById(R.id.etPassword);

        btnLogin.findViewById(R.id.btnLogin);
        btnRegister.findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = etUserName.getText().toString();
                pass = etPassword.getText().toString();

                Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();


            }
        });
            return view;

    }

}
