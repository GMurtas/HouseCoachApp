package com.example.giuliam.housecoach;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.giuliam.housecoach.App.CHANNEL_ID;


public class TasksFragment extends android.support.v4.app.Fragment {
    private MyViewModel model;
    private NotificationManagerCompat notificationManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, null);
        model = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        TextView task1 = view.findViewById(R.id.task1);
        TextView task2 = view.findViewById(R.id.task2);
        TextView task3 = view.findViewById(R.id.task3);

        notificationManager = NotificationManagerCompat.from(getContext());

        if (model.GarbageLevel == 0) {
            task1.setTextColor(getResources().getColor(R.color.red));
            }
        else {task1.setTextColor(getResources().getColor(R.color.green));
        }
        if (model.LaundryLevel == 0) {
            task2.setTextColor(getResources().getColor(R.color.red));
            }
        else {task2.setTextColor(getResources().getColor(R.color.green));
        }
        if (model.DustLevel == 0) {
            task3.setTextColor(getResources().getColor(R.color.red));

        }
        else {task3.setTextColor(getResources().getColor(R.color.green));
           }

        if(model.GarbageLevel == 0 || model.LaundryLevel == 0 || model.DustLevel == 0) {
            sendNotification();
        }

        return view;

    }

    public void sendNotification() {

        Intent activityIntent = new Intent(getContext(), MainActivity.class);
        activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent contentIntent = PendingIntent.getActivity(getContext(), 0, activityIntent, PendingIntent.FLAG_ONE_SHOT);
        Notification notification = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_announcement)
                .setContentTitle("House Coach")
                .setContentText("Time to clean!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .build();

        notificationManager.notify(1, notification);

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}