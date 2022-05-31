package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.Serializable;
import java.util.ArrayList;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }
    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<Item> myItems = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)myItems);
                i.putExtra("BUNDLE",args);
                startActivity(i);
                finish();
            }
        }, 1000);
    }
}