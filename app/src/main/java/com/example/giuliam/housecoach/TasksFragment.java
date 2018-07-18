package com.example.giuliam.housecoach;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class TasksFragment extends android.support.v4.app.Fragment {
    private MyViewModel model;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, null);
        model = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        TextView task1 = view.findViewById(R.id.task1);
        TextView task2 = view.findViewById(R.id.task2);
        TextView task3 = view.findViewById(R.id.task3);

        if (model.GarbageLevel < 5) {
            task1.setTextColor(getResources().getColor(R.color.red));
            model.stateTask1 = 0;
        }
        else {task1.setTextColor(getResources().getColor(R.color.green));
            model.stateTask1 = 1;
        }
        if (model.LaundryLevel < 5) {
            task2.setTextColor(getResources().getColor(R.color.red));
            model.stateTask2 = 0;
        }
        else {task2.setTextColor(getResources().getColor(R.color.green));
            model.stateTask2 = 1;}
        if (model.DustLevel > 10) {
            task3.setTextColor(getResources().getColor(R.color.red));
            model.stateTask1 = 0;
        }
        else {task3.setTextColor(getResources().getColor(R.color.green));
            model.stateTask1 = 1;}

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}