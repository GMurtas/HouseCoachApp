package com.example.giuliam.housecoach;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class App extends Application {
    public static final String CHANNEL_ID = "channel";
    public int flagv1, flagv2, flagv3,flagv4, flagGadget;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("User notified to check status");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

    /*public App (int flagv1, int flagv2, int flagv3, int flagv4, int flagGadget)
    {
        this.setFlagv1(flagv1);
        this.setFlagv2(flagv2);
        this.setFlagv3(flagv3);
        this.setFlagv4(flagv4);
        this.setFlagGadget(flagGadget);

    }

    public int getFlagv1(){
        return flagv1;
    }

    public int getFlagv2() {
        return flagv2;
    }

    public int getFlagv3() {
        return flagv3;
    }

    public int getFlagv4() {
        return flagv4;
    }

    public int getFlagGadget() {
        return flagGadget;
    }

    public void setFlagv1(int flagv1) {
        this.flagv1 = flagv1;
    }

    public void setFlagv2(int flagv2) {
        this.flagv2 = flagv2;
    }

    public void setFlagv3(int flagv3) {
        this.flagv3 = flagv3;
    }

    public void setFlagv4(int flagv4) {
        this.flagv4 = flagv4;
    }

    public void setFlagGadget(int flagGadget) {
        this.flagGadget = flagGadget;
    } */
}

