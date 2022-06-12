package com.example.lively;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.lively.database.tables.Users;
import com.example.lively.fragments.dashboard.DashboardFragment;
import com.example.lively.fragments.exercise.ExerciseFragment;
import com.example.lively.fragments.food.FoodFragment;
import com.example.lively.fragments.ViewPageAdapter;
import com.example.lively.fragments.home.HomeFragment;
import com.example.lively.fragments.sleep.SleepFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FragmentContainerView fragmentContainerView;
    public Users user = new Users("Dorijan","dorijan.komsic@gmail.com","12345");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        fragmentContainerView = findViewById(R.id.frag_container_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_view,
                new HomeFragment()).commit();

    }

}