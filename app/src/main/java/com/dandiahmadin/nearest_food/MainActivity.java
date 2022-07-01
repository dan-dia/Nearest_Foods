package com.dandiahmadin.nearest_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.dandiahmadin.nearest_food.fragment.AboutFragment;
import com.dandiahmadin.nearest_food.fragment.MapsFragment;
import com.dandiahmadin.nearest_food.fragment.MyLocationFragment;
import com.dandiahmadin.nearest_food.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

// NIM   : 10119033
// Nama  : Dandi Ahmadin
// Kelas : IF-1

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment(new MapsFragment());
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.btn_maps:
                        fragment = new MapsFragment();
                        break;
                    case R.id.btn_my_loc:
                        fragment = new MyLocationFragment();
                        break;
                    case R.id.btn_profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.btn_about:
                        fragment = new AboutFragment();
                        break;
                    default:
                        fragment = null;
                }

                initFragment(fragment);
                return true;
            }
        });
    }

    private void initFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container_fragment, fragment)
                .commit();
    }
}