package com.example.giuliam.housecoach;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class listAdapter extends ArrayAdapter<ItemGadget> {

    Context mCtx;
    int resource;
    List<ItemGadget> gadgetList;

    public listAdapter(Context mCtx, /*int resource,*/ List<ItemGadget> gadgetList) {

        super(mCtx, R.layout.list_item, gadgetList);
        //this.mCtx = mCtx;
        //this.resource = resource;
        this.gadgetList = gadgetList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View customView = inflater.inflate(R.layout.list_item, parent, false);

        TextView tvproduct = customView.findViewById(R.id.tvProduct);
        ImageView imageGadget = customView.findViewById(R.id.imageGadget);
        Button button = customView.findViewById(R.id.buy);
        ItemGadget itemGadget = gadgetList.get(position);

        tvproduct.setText(itemGadget.getProduct());
        imageGadget.setImageDrawable(mCtx.getResources().getDrawable(itemGadget.getImage()));
        return customView;
    }
}
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });



    private void removeItem(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        builder.setTitle("Are you sure you want to buy the gadget?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                gadgetList.remove(position);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}*/
