package com.example.giuliam.housecoach;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import static com.example.giuliam.housecoach.App.CHANNEL_ID;


import static com.example.giuliam.housecoach.App.CHANNEL_ID;

public class AlertReceiver extends BroadcastReceiver {
    String title = "House Coach";
    String message = "Check the status of your house!";
    private NotificationManagerCompat notificationManager;


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(title, message);
        notificationHelper.getManager().notify(1, nb.build());


        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) { //notification should be sent even if device is rebooted
            notificationHelper.getManager().notify(1, nb.build());
        }

    }
}


