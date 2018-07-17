package com.example.giuliam.housecoach;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GadgetsFragment extends android.support.v4.app.Fragment  {

    List<ItemGadget> itemGadgetList;
    ListView listView;
    Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, null);

        itemGadgetList = new ArrayList<>();

        itemGadgetList.add(new ItemGadget(R.drawable.dog, "Happy dog"));
        itemGadgetList.add(new ItemGadget(R.drawable.cat, "Lazy cat"));

        ListView listView = getView().findViewById(R.id.listView);

        listAdapter adapter = new listAdapter(context, itemGadgetList);
        listView.setAdapter(adapter);

        return view;
        }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.listView);
        view.findViewById(R.id.gadgetsF);









    }
}
