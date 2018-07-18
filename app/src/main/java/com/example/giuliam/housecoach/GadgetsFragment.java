package com.example.giuliam.housecoach;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GadgetsFragment extends android.support.v4.app.Fragment  {
    private MyViewModel model;





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gadgets, null);
        TextView name = view.findViewById(R.id.gName);
        ImageView dog = view.findViewById(R.id.ivDog);
        return view;
        }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Button b = view.findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               b.setVisibility(View.GONE);
               model.gClicked = 1;





            }
        });










    }
}
