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
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class GadgetsFragment extends android.support.v4.app.Fragment  {

    Context mContext;







    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gadgets, null);
        TextView name = view.findViewById(R.id.gName);
        ImageView glasses = view.findViewById(R.id.ivGlasses);
        Button b = view.findViewById(R.id.b);
        mContext = getContext();
        Boolean fGlasses = KeyValueDB.getGadget1(getContext());
        if (fGlasses == true) {
            b.setVisibility(View.GONE);
        }




        return view;
        }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button b = view.findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = KeyValueDB.getscore(getContext());
                int price = Integer.parseInt(b.getText().toString());
                if (score < price) {
                    Toast.makeText(getActivity(), "You don't have enough points!", Toast.LENGTH_LONG).show();
                }
                else {
                    b.setVisibility(View.GONE);
                    KeyValueDB.setGadget1(mContext, true);
                    KeyValueDB.setscore(mContext, score - price);
                }
            }
        });










    }
}
