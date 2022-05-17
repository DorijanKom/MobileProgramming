package com.example.lively;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private NavigationBarView navigationBarView;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.fragment_container);
        navigationBarView = findViewById(R.id.bottom_navigation_bar);
        navigationBarView.setOnItemSelectedListener(onNavigationItemSelectedListener);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationBarView.setSelectedItemId(R.id.nav_dashboard);
                        break;
                    case 1:
                        navigationBarView.setSelectedItemId(R.id.nav_exercise);
                        break;
                    case 2:
                        navigationBarView.setSelectedItemId(R.id.nav_food);
                        break;
                    case 3:
                        navigationBarView.setSelectedItemId(R.id.nav_sleep);
                        break;
                    default:
                        break;
                }
            }
        });
        setUpAdapter();
    }


    private void setUpAdapter(){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);

        viewPageAdapter.addFragment(new DashboardFragment());
        viewPageAdapter.addFragment(new ExerciseFragment());
        viewPageAdapter.addFragment(new FoodFragment());
        viewPageAdapter.addFragment(new SleepFragment());

        viewPager2.setAdapter(viewPageAdapter);
    }

    private NavigationBarView.OnItemSelectedListener onNavigationItemSelectedListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Log.d("DEBUG","Item clicked "+item.getItemId());
                    switch (item.getItemId()){
                        case R.id.nav_dashboard:
                            viewPager2.setCurrentItem(0);
                            return true;
                        case R.id.nav_exercise:
                            viewPager2.setCurrentItem(1);
                            return true;
                        case R.id.nav_food:
                            viewPager2.setCurrentItem(2);
                            return true;
                        case R.id.nav_sleep:
                            viewPager2.setCurrentItem(3);
                            return true;
                        default:
                            return false;
                    }
                }
            };
}