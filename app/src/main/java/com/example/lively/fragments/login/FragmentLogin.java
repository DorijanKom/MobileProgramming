package com.example.lively.fragments.login;


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
import com.example.lively.database.dao.usersDAO;
import com.example.lively.database.tables.Users;
import com.example.lively.fragments.dashboard.DashboardFragment;
import com.example.lively.fragments.register.FragmentRegister;


public class FragmentLogin extends Fragment {

    Button btnLogin, btnRegister;
    EditText etUserName, etPassword;



    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnRegister = view.findViewById(R.id.btnRegister);
        etUserName = view.findViewById(R.id.etUserName);
        etPassword = view.findViewById(R.id.etPassword);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getParentFragmentManager().beginTransaction().replace(R.id.frag_container_view, new FragmentRegister()).commit();

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(getContext(), "Fill in the required fields!", Toast.LENGTH_SHORT).show();
                } else {
                    LivelyDatabase livelyDatabase = LivelyDatabase.getDatabase(getContext());
                    usersDAO usersDao = livelyDatabase.usersDAO();
                    Users users = usersDao.login(username, password);
                    if (users == null) {
                        Toast.makeText(getContext(), "Invalid password or username!", Toast.LENGTH_SHORT).show();
                    } else {
                        ((MainActivity) getActivity()).user = users;
                        getParentFragmentManager().beginTransaction().replace(R.id.frag_container_view, new DashboardFragment()).commit();
                    }


                }

            }
        });
        return view;
    }

}


