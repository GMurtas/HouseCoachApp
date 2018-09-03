package com.example.giuliam.housecoach;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyValueDB {

//Saved: value1, value2, value3, gadget1, score

    private SharedPreferences sharedPreferences;
    private static String PREF_NAME = "prefs";

    public KeyValueDB() {
        // Blank
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static Integer getv1(Context context) {
        return getPrefs(context).getInt("v1", 1);
    }

    public static void setv1(Context context, Integer v1) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("v1",v1);
        editor.commit();
    }

    public static Integer getv2(Context context) {
        return getPrefs(context).getInt("v2", 1);
    }

    public static void setv2(Context context, Integer v2) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("v2",v2);
        editor.commit();
    }

    public static Integer getv3(Context context) {
        return getPrefs(context).getInt("v3", 1);
    }

    public static void setv3(Context context, Integer v3) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("v3",v3);
        editor.commit();
    }

    public static Boolean getGadget1(Context context) {
        return getPrefs(context).getBoolean("g1", false);
    }

    public static void setGadget1(Context context, Boolean g1) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putBoolean("g1",g1);
        editor.commit();
    }

    public static Integer getscore(Context context) {
        return getPrefs(context).getInt("score", 0);
    }

    public static void setscore(Context context, Integer score) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("score", score);
        editor.commit();
    }
}


