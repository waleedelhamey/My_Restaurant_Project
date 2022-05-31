package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    Button clearBtn;
    TextView totalTV;
    CartListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        clearBtn = findViewById(R.id.clear_btn);
        totalTV = findViewById(R.id.total_tv);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Item> myItems = (ArrayList<Item>) args.getSerializable("ARRAYLIST");

        double total = setTotal(myItems);
        totalTV.setText("Total: "+String.valueOf(total));
        ListView mListView = (ListView) findViewById(R.id.cart_listView);
        adapter = new CartListAdapter(CartActivity.this,R.layout.adapter_cart_view_layout,myItems);
        mListView.setAdapter(adapter);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItems.clear();
//                adapter = new CartListAdapter(CartActivity.this,R.layout.adapter_cart_view_layout,myItems);
//                mListView.setAdapter(adapter);
                Toast.makeText(CartActivity.this,"Your cart is cleared",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CartActivity.this,MainActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)myItems);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
                //totalTV.setText("Total: 0");
            }
        });

    }
    public double setTotal(ArrayList<Item> myItems){
        double total=0;
        for (int i=0;i<myItems.size();++i){
            total+=(myItems.get(i).price* myItems.get(i).getQuantity());
        }
        DecimalFormat twoDForm = new DecimalFormat("#.####");
        return Double.valueOf(twoDForm.format(total));
    }
}