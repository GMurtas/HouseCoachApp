package com.example.giuliam.housecoach;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
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
        ImageView face = view.findViewById(R.id.face);
        Integer v2;

        v2 = 0;
        if (v2 > 0) {
            face.setImageDrawable(getResources().getDrawable(R.drawable.angryface));
        }
        else {
            face.setImageDrawable(getResources().getDrawable(R.drawable.smileyface));
        }


        return view;}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}