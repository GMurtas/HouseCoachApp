package com.example.giuliam.housecoach;

import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    public int gClicked = 0;
    public int GarbageLevel = 0; //1 if ok, 0 if must intervene
    public int DustLevel = 1;
    public int LaundryLevel = 1;
    public int angry = DustLevel + LaundryLevel + GarbageLevel;


}
