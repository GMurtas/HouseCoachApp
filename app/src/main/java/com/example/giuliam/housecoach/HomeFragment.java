package com.example.giuliam.housecoach;

import android.app.Fragment;
import android.content.Intent;
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



public class HomeFragment extends android.support.v4.app.Fragment {
    private MyViewModel model;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        TextView score = view.findViewById(R.id.score);

        ImageView happy = view.findViewById(R.id.happy);
        ImageView angry = view.findViewById(R.id.angry);
        ImageView dog = view.findViewById(R.id.ivDog);
        int garbage = model.GarbageLevel;
        int dust = model.DustLevel;
        int laundry = model.LaundryLevel;



        if (garbage < 5 || dust> 10 || laundry < 5) {
            //1 red, Angry face
            happy.setVisibility(View.GONE);
            angry.setVisibility(View.VISIBLE);
        }

        /*if (model.gClicked == 1) {
            dog.setVisibility(View.VISIBLE);
            score.setText("00");
        }*/



        return view;}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}