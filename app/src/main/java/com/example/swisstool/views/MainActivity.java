package com.example.swisstool.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.swisstool.R;
import com.example.swisstool.views.AlphabetFragment;
import com.example.swisstool.views.HomeFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.HomeFragmentInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadHomeFragment();
    }

    private void loadHomeFragment() {
        loadFragment(new HomeFragment(this));
    }

    @Override
    public void loadAlphabetViewer() {
        loadFragmentWithBackStack(new AlphabetFragment(), "AlphabetFragment");
    }

    @Override
    public void loadStressTapper() {

    }

    @Override
    public void loadBirthstones() {

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame1, fragment)
                .commit();
    }

    private void loadFragmentWithBackStack(Fragment fragment, String fragName) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame1, fragment)
                .addToBackStack(fragName)
                .commit();
    }
}