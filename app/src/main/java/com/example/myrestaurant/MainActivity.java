package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView hamburgarIV,saladIV,steakIV,icecreamIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Item> myItems = (ArrayList<Item>) args.getSerializable("ARRAYLIST");

        hamburgarIV=findViewById(R.id.hamburgar_img);
        hamburgarIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FoodListActivity.class);
                intent.putExtra("category","Hamburgar");
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)myItems);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });

        saladIV=findViewById(R.id.salad_img);
        saladIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FoodListActivity.class);
                intent.putExtra("category","Salad");
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)myItems);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });

        steakIV=findViewById(R.id.steak_img);
        steakIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FoodListActivity.class);
                intent.putExtra("category","Steak");
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)myItems);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });

        icecreamIV=findViewById(R.id.ice_cream_img);
        icecreamIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FoodListActivity.class);
                intent.putExtra("category","Icecream");
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)myItems);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });

    }

}