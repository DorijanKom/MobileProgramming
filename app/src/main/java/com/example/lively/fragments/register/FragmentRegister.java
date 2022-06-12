package com.example.lively.fragments.register;

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

import com.example.lively.MainActivity;
import com.example.lively.R;
import com.example.lively.database.LivelyDatabase;
import com.example.lively.database.tables.Users;
import com.example.lively.fragments.login.FragmentLogin;
import com.example.lively.fragments.user_data.UserDataFragment;


public class FragmentRegister extends Fragment {


    private Button btnRegister;
    private Button btnLogin;
    private EditText etUserName, etPassword, etEmail;
    private String userName, email, pass;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);
        etUserName = view.findViewById(R.id.etUserName);
        etPassword = view.findViewById(R.id.etPassword);
        etEmail = view.findViewById(R.id.etEmail);
        btnRegister.findViewById(R.id.btnRegister);
        btnLogin.findViewById(R.id.btnLogin);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();




                if (username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(getContext(), "Fill in the required fields!", Toast.LENGTH_SHORT).show();
                } else {
                    Users users = new Users(etUserName.getText().toString(), etPassword.getText().toString(), email = etEmail.getText().toString());
                    LivelyDatabase.getDatabase(getContext()).usersDAO().addUsers(users);
                    Toast.makeText(getContext(), "Registered", Toast.LENGTH_SHORT).show();
                    ((MainActivity) getActivity()).user = users;


                }
            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getParentFragmentManager().beginTransaction().replace(R.id.frag_container_view, new FragmentLogin()).commit();

            }
        });







        return view;
    }
}
