package com.example.giuliam.housecoach;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class HomeFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        if (GadgetsFragment.dogClicked == 1) {
            ImageView dog = view.findViewById(R.id.ivDog);
            dog.setVisibility(View.VISIBLE);


        }


        return view;}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView score = view.findViewById(R.id.score);

        ImageView happy = view.findViewById(R.id.happy);
        ImageView angry = view.findViewById(R.id.angry);

    }
}