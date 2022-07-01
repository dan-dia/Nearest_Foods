package com.dandiahmadin.nearest_food.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dandiahmadin.nearest_food.R;
import com.dandiahmadin.nearest_food.fragment.viewpager2.FirstFragment;
import com.dandiahmadin.nearest_food.fragment.viewpager2.SecondaryFragment;
// NIM   : 10119033
// Nama  : Dandi Ahmadin
// Kelas : IF-1
public class AboutFragment extends Fragment {

    private ViewPager2 viewPager2;
    private final int NUM_FRAGMENT = 2;
    private FragmentStateAdapter fragmentStateAdapter;

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        viewPager2 = view.findViewById(R.id.container_viewpager2);

        fragmentStateAdapter = new SlideScreenPageAdapter(this);
        viewPager2.setAdapter(fragmentStateAdapter);
        return view;
    }

    private class SlideScreenPageAdapter extends FragmentStateAdapter {
        public SlideScreenPageAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new FirstFragment();
                case 1:
                    return new SecondaryFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_FRAGMENT;
        }
    }
}