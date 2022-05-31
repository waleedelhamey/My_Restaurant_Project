package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView itemNameTV,descContTV,itemPriceTV;
    EditText quantityET;
    ImageView itemIV;
    Button addItemBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        Item item = (Item) getIntent().getSerializableExtra("item name");
        String category = bundle.getString("category");
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Item> myItems = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        addItemBtn = findViewById(R.id.additem_btn);
        quantityET = findViewById(R.id.quantity_edittxt);
        descContTV = findViewById(R.id.description_content_txtv);
        itemPriceTV = findViewById(R.id.item_price_txtv);
        itemNameTV = findViewById(R.id.itemname_txtv);
        itemIV = findViewById(R.id.item_imgv);
        descContTV.setText(item.getDescription().toString());
        itemPriceTV.setText(String.valueOf(item.getPrice()));
        itemNameTV.setText(item.getName().toString());
        itemIV.setImageDrawable(getResources().getDrawable(item.getItemImg()));
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantityET.getText().toString().isEmpty()){
                    Toast.makeText(DetailActivity.this,"Please enter the quantity",Toast.LENGTH_SHORT).show();
                }
                else{
                    int quantity = Integer.parseInt(quantityET.getText().toString());
                    Toast.makeText(DetailActivity.this,quantity+" items are added",Toast.LENGTH_SHORT).show();
                    int indx=ifExisted(myItems,item.getName());
                    if(indx==-1){// If the item is not in myItems
                        item.setQuantity(quantity);
                        myItems.add(item);
                    }else{// If the item is in myItems
                        quantity+=myItems.get(indx).getQuantity();
                        myItems.get(indx).setQuantity(quantity);
                    }
                    Intent intent = new Intent(DetailActivity.this,FoodListActivity.class);
                    intent.putExtra("category",category);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)myItems);
                    intent.putExtra("BUNDLE",args);
                    startActivity(intent);
                }
            }
        });
    }
    int ifExisted(ArrayList<Item> myItems,String itemName){
        for(int i=0;i<myItems.size();++i){
            if(myItems.get(i).getName().equalsIgnoreCase(itemName)){
                return i;
            }
        }
        return -1;
    }
}