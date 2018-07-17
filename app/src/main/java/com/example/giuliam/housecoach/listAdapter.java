package com.example.giuliam.housecoach;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class listAdapter extends BaseAdapter {

    private Context context;
    private List<ItemGadget> listGadgets;

    public listAdapter(Context context, List<ItemGadget> listGadgets){
        this.context = context;
        this.listGadgets = listGadgets;
    }

    @Override
    public int getCount() {
        return listGadgets.size();
    }

    @Override
    public Object getItem(int position) {
        return listGadgets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);

            viewHolder = new ViewHolder();

            viewHolder.ivGadget = convertView.findViewById(R.id.ivGadget);
            viewHolder.tvGadget = convertView.findViewById(R.id.tvGadget);
            viewHolder.bGadget = convertView.findViewById(R.id.bGadget);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ItemGadget itemGadget = listGadgets.get(position);

        viewHolder.tvGadget.setText(itemGadget.getGadgetName());
        viewHolder.ivGadget.setImageDrawable(getImageDrawable(itemGadget.getImageName()));
        viewHolder.bGadget.setText(itemGadget.getButtonName());
        return convertView;
    }

    private Drawable getImageDrawable(String imageName){
        int id  = context.getResources().getIdentifier(imageName, "drawable",
                context.getPackageName());
        return context.getResources().getDrawable(id);
    }

    class ViewHolder{
        ImageView ivGadget;
        TextView tvGadget;
        Button bGadget;
    }

}