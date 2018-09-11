package com.example.giuliam.housecoach;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.rgb;


public class SensorsValueAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public SensorsValueAdapter(@NonNull Context context, int resource) {

        super(context, resource);
    }


    public void add(SensorsValue object) {
        super.add(object);
        list.add(object);
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        SensorsValueHolder sensorsValueHolder;
        Integer  v2, v3, v4;
        Float v1;
        Integer previous, current;
        Integer delta = 0;
        ///////
        //KeyValueDB.setdelta(getContext(), 0);
        //set all sensor values to zero; now
        //KeyValueDB.setv1(getContext(), 0);
        //KeyValueDB.setv2(getContext(), 0);
        //KeyValueDB.setv3(getContext(), 0);

        if(row==null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            sensorsValueHolder = new SensorsValueHolder();
            sensorsValueHolder.tx_value1 = (TextView)row.findViewById(R.id.tx_value1);
            sensorsValueHolder.tx_value2 = (TextView)row.findViewById(R.id.tx_value2);
            sensorsValueHolder.tx_value3 = (TextView)row.findViewById(R.id.tx_value3);
            sensorsValueHolder.tx_value4 = (TextView)row.findViewById(R.id.tx_value4);
            row.setTag(sensorsValueHolder);
        }
        else {
            sensorsValueHolder = (SensorsValueHolder)row.getTag();
        }
        SensorsValue sensorsValue = (SensorsValue)getItem(position);

        //convert String to int to check condition on sensor data, change color of the text
        v1 = Float.parseFloat(sensorsValue.getValue1());
        v2 = Integer.parseInt(sensorsValue.getValue2());
        v3 = Integer.parseInt(sensorsValue.getValue3());
        //v4 = Integer.parseInt(sensorsValue.getValue4());

        //Value_1 is dust, 2 and 3 are bins; 2 for laundry, 3 for garbage
        sensorsValueHolder.tx_value1.setText("Dust in the room");
        sensorsValueHolder.tx_value2.setText("Laundry");
        sensorsValueHolder.tx_value3.setText("Garbage");

        //dust sensor
        previous = KeyValueDB.getv1(getContext());
        if (v1 > 0) {                                                            //set exact limits
            sensorsValueHolder.tx_value1.setTextColor(rgb(255, 0, 0));
            KeyValueDB.setv1(getContext(), 0);
        } else {
            sensorsValueHolder.tx_value1.setTextColor(rgb(0, 180, 0));
            KeyValueDB.setv1(getContext(), 1);
            if (previous == 0)
                delta++;
        }

        //bin sensor for laundry
        previous = KeyValueDB.getv2(getContext());
        if (v2 < 10) {                                                            //set exact limits
            sensorsValueHolder.tx_value2.setTextColor(rgb(255, 0, 0));
            KeyValueDB.setv2(getContext(), 0);
        } else {
            sensorsValueHolder.tx_value2.setTextColor(rgb(0, 180, 0));
            KeyValueDB.setv2(getContext(), 1);
            if (previous == 0)
                delta++;
        }

        //bin sensor for garbage
        previous = KeyValueDB.getv3(getContext());
        if (v3 < 10) {                                                            //set exact limits
            sensorsValueHolder.tx_value3.setTextColor(rgb(255, 0, 0));
            KeyValueDB.setv3(getContext(), 0);
        } else {
            sensorsValueHolder.tx_value3.setTextColor(rgb(0, 180, 0));
            KeyValueDB.setv3(getContext(), 1);
            if (previous == 0)
                delta++;
        }

        KeyValueDB.setdelta(getContext(), delta);
        Integer score, savedScore;
        score = delta;
        savedScore = KeyValueDB.getscore(getContext());
        KeyValueDB.setscore(getContext(), score + savedScore);
        KeyValueDB.setdelta(getContext(), 0);

        //sensorsValueHolder.tx_value4.setText(sensorsValue.getValue4());
        return row;
    }

    static class SensorsValueHolder
    {
        TextView tx_value1, tx_value2, tx_value3, tx_value4;
    }
}
