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
   Boolean gadget;
   Integer v1, v2, v3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        TextView score = view.findViewById(R.id.score);
        ImageView face = view.findViewById(R.id.face);
        String scoreText;
        scoreText = Integer.toString(KeyValueDB.getscore(getContext()));
        score.setText(scoreText);

        v1 = KeyValueDB.getv1(getContext());
        v2 = KeyValueDB.getv2(getContext());
        v3 = KeyValueDB.getv3(getContext());
        KeyValueDB.setGadget1(getContext(), false); //---to be commented to reset bought gadget

        gadget = KeyValueDB.getGadget1(getContext());

        if (v1+v2+v3 == 3) {
            if (gadget == true)
                face.setImageDrawable(getResources().getDrawable(R.drawable.smileyglasses));
            else
                face.setImageDrawable(getResources().getDrawable(R.drawable.smileyface));
        }

        else if (v1+v2+v3 == 2) {
            if (gadget == true)
                face.setImageDrawable(getResources().getDrawable(R.drawable.annoyedglasses));
            else
                face.setImageDrawable(getResources().getDrawable(R.drawable.annoyed));
        }

        else {
            if (gadget == true)
                face.setImageDrawable(getResources().getDrawable(R.drawable.angryglasses));
            else
                face.setImageDrawable(getResources().getDrawable(R.drawable.angryface));

        }




        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}