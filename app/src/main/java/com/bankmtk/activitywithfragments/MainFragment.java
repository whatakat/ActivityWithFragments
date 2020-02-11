package com.bankmtk.activitywithfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private String shape;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main,container,false);
        shape = getString(R.string.lion);
        final ImageView imageView = fragmentView.findViewById(R.id.imageView);
        RadioButton radioLion = fragmentView.findViewById(R.id.radioLion);
        radioLion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.lion);
                shape = getString(R.string.lion);
            }
        });
        RadioButton radioShark = fragmentView.findViewById(R.id.radioShark);
        radioShark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.shark);
                shape = getString(R.string.shark);
            }
        });
        Button button = fragmentView.findViewById(R.id.button);
        final Activity that = getActivity();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainNavigator mainNavigator = (MainNavigator)that;
                mainNavigator.startSecondFragment(shape);
            }
        });
        return fragmentView;
    }
}
