package com.example.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CartListAdapter extends ArrayAdapter<Item> {
    private static final String TAG = "List";
    private Context context;
    int resource;

    public CartListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        double price = getItem(position).getPrice();
        int quantity = getItem(position).getQuantity();
        double total = Double.valueOf( price* quantity);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);
        TextView itemName = (TextView) convertView.findViewById(R.id.itemName_tx);
        TextView itemQuantity = (TextView) convertView.findViewById(R.id.itemquantity_tx);
        TextView itemPrice = (TextView) convertView.findViewById(R.id.itemprice_tx);
        TextView totalPrice = (TextView) convertView.findViewById(R.id.total_tx);

        itemName.setText(name);
        itemQuantity.setText(String.valueOf(quantity));
        itemPrice.setText(String.valueOf(price));
        totalPrice.setText(String.valueOf(total));

        return convertView;
    }
}
