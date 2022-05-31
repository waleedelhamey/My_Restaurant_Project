package com.example.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {
    private static final String TAG = "List";
    private Context context;
    int resource;

    public ItemListAdapter(@NonNull Context context, int resource, @NonNull ArrayList <Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        double price = getItem(position).getPrice();
        String description = getItem(position).getDescription();
        int itemImg = getItem(position).getItemImg();
        Item item = new Item(name,description,price,itemImg);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);
        TextView tvName = (TextView) convertView.findViewById(R.id.item);
        tvName.setText(name);
        return convertView;
    }
}
