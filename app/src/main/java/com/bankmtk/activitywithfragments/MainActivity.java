package com.bankmtk.activitywithfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  MainNavigator{
    private MainFragment mainFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        secondFragment = new SecondFragment();
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, mainFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void startSecondFragment(String shape) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(mainFragment);
        fragmentTransaction.add(R.id.fragment_container,secondFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
        secondFragment.setShape(shape);
    }
}
