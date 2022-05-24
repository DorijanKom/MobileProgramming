package com.example.lively.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.lively.R;
import com.example.lively.fragments.ViewPageAdapter;
import com.example.lively.fragments.dashboard.DashboardFragment;
import com.example.lively.fragments.exercise.ExerciseFragment;
import com.example.lively.fragments.food.FoodFragment;
import com.example.lively.fragments.sleep.SleepFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeFragment extends Fragment {

    private ViewPageAdapter viewPageAdapter;
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        viewPager2 = view.findViewById(R.id.viewPager);
        bottomNavigationView = view.findViewById(R.id.botNavView);
        viewPageAdapter = new ViewPageAdapter(requireActivity());
        viewPager2.setAdapter(viewPageAdapter);

        viewPageAdapter.addFragment(new DashboardFragment());
        viewPageAdapter.addFragment(new ExerciseFragment());
        viewPageAdapter.addFragment(new FoodFragment());
        viewPageAdapter.addFragment(new SleepFragment());


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.nav_dashboard);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.nav_exercise);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.nav_food);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.nav_sleep);
                        break;
                    default:
                        break;
                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_dashboard:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.nav_exercise:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.nav_food:
                        viewPager2.setCurrentItem(2);
                        break;
                    case R.id.nav_sleep:
                        viewPager2.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        return view; // RegisterPageChange callback i ItemChanged listener
    }
}
