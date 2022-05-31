package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity  {
    TextView categorytx,totalTV;
    Button cartBtn;
    private static final String TAG = "FoodListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Item> myItems = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        String category = bundle.getString("category");
        Log.d(TAG,"onCreate: Started.");
        totalTV = findViewById(R.id.total_tv);
        double total = setTotal(myItems);
        totalTV.setText("Total: "+String.valueOf(total));
        cartBtn = findViewById(R.id.cart_btn);
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodListActivity.this,CartActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)myItems);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });



        ListView mListView = (ListView) findViewById(R.id.list_view);
        ArrayList<Item> hamburgarList = new ArrayList<>();
        ArrayList<Item> saladList = new ArrayList<>();
        ArrayList<Item> steakList = new ArrayList<>();
        ArrayList<Item> icecreamList = new ArrayList<>();

        createHamburgarList(hamburgarList);
        createSaladList(saladList);
        createSteakList(steakList);
        createIcecreamList(icecreamList);
        ItemListAdapter adapter = new ItemListAdapter(this,R.layout.activity_view_layout,hamburgarList);
        ItemListAdapter adapter2 = new ItemListAdapter(this,R.layout.activity_view_layout,saladList);
        ItemListAdapter adapter3 = new ItemListAdapter(this,R.layout.activity_view_layout,steakList);
        ItemListAdapter adapter4 = new ItemListAdapter(this,R.layout.activity_view_layout,icecreamList);

        if(category.equalsIgnoreCase("Hamburgar")){
            mListView.setAdapter(adapter);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position,
                                        long id) {

                    Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
                    intent.putExtra("item name",hamburgarList.get(position));
                    intent.putExtra("category",category);

                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)myItems);
                    intent.putExtra("BUNDLE",args);
                    startActivity(intent);
                }
            });
        }else if(category.equalsIgnoreCase("Salad")){
            mListView.setAdapter(adapter2);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position,
                                        long id) {

                    Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
                    intent.putExtra("item name",saladList.get(position));
                    intent.putExtra("category",category);

                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)myItems);
                    intent.putExtra("BUNDLE",args);
                    startActivity(intent);
                }
            });
        }else if(category.equalsIgnoreCase("Steak")){
            mListView.setAdapter(adapter3);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position,
                                        long id) {

                    Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
                    intent.putExtra("item name",steakList.get(position));
                    intent.putExtra("category",category);

                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)myItems);
                    intent.putExtra("BUNDLE",args);
                    startActivity(intent);
                }
            });
        }else if(category.equalsIgnoreCase("icecream")){
            mListView.setAdapter(adapter4);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position,
                                        long id) {

                    Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
                    intent.putExtra("item name",icecreamList.get(position));
                    intent.putExtra("category",category);

                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)myItems);
                    intent.putExtra("BUNDLE",args);
                    startActivity(intent);
                }
            });
        }


    }

    private void createIcecreamList(ArrayList<Item> foodList) {
        int res;
        res = getResources().getIdentifier("coconut_icecream", "drawable", this.getPackageName());
        Item item1 = new Item("Coconut Ice cream","Coconut milk, Vanilla extract",5.99,res);

        res = getResources().getIdentifier("strawberry_icecream", "drawable", this.getPackageName());
        Item item2 = new Item("Strawberry Ice cream","Creamy strawberry taste, soft serve topped with a sweet strawberry sauce",5.99,res);

        res = getResources().getIdentifier("mango_icecream", "drawable", this.getPackageName());
        Item item3 = new Item("Mango Ice cream","Creamy mango taste, soft serve topped with a sweet mango sauce",5.99,res);

        res = getResources().getIdentifier("lemon_icecream", "drawable", this.getPackageName());
        Item item4 = new Item("Lemon Ice cream","Creamy lemon taste, soft serve topped with a sweet lemon sauce",5.99,res);

        res = getResources().getIdentifier("vanilla_icecream", "drawable", this.getPackageName());
        Item item5 = new Item("Vanilla Ice cream","Creamy vanilla taste, soft serve topped with no sauce",5.99,res);
        foodList.add(item1);
        foodList.add(item2);
        foodList.add(item3);
        foodList.add(item4);
        foodList.add(item5);

    }

    private void createSteakList(ArrayList<Item> foodList) {
        int res;
        res = getResources().getIdentifier("beef_steak", "drawable", this.getPackageName());
        Item item1 = new Item("Beef Steak","Beef chops with marmalade mustard pan sauce ",11.99,res);

        res = getResources().getIdentifier("pork_steak", "drawable", this.getPackageName());
        Item item2 = new Item("Pork Steak","Pork chops with marmalade mustard pan sauce ",15.99,res);

        res = getResources().getIdentifier("fish_steak", "drawable", this.getPackageName());
        Item item3 = new Item("Fish Steak","Fish chops with marmalade mustard pan sauce ",19.99,res);

        res = getResources().getIdentifier("lamb_steak", "drawable", this.getPackageName());
        Item item4 = new Item("Lamb Steak","Lamb chops with marmalade mustard pan sauce ",13.99,res);
        foodList.add(item1);
        foodList.add(item2);
        foodList.add(item3);
        foodList.add(item4);
    }

    private void createSaladList(ArrayList<Item> foodList) {
        int res;
        res = getResources().getIdentifier("caesar_salad", "drawable", this.getPackageName());
        Item item1 = new Item("Caesar Salad","Romaine lettuce, parmesan cheese, crisp croutons, and caesar salad dressing",11.99,res);

        res = getResources().getIdentifier("greek_salad", "drawable", this.getPackageName());
        Item item2 = new Item("Greek Salad","Sliced cucumbers, tomatoes, green bell pepper, red onion, olives, and feta cheese.",15.99,res);

        res = getResources().getIdentifier("italian_salad", "drawable", this.getPackageName());
        Item item3 = new Item("Italian Salad","Romaine lettuce, red bell pepper, hothouse cucumbers, carrots, tomatoes, pitted olives",19.99,res);

        res = getResources().getIdentifier("ambrosia_salad", "drawable", this.getPackageName());
        Item item4 = new Item("Ambrosia Salad","Frozen whipped topping, Vanilla yogurt, sweetened coconut, mandarin oranges, pineapple, maraschino cherries, pecans, fruit-flavored marshmallows",13.99,res);
        foodList.add(item1);
        foodList.add(item2);
        foodList.add(item3);
        foodList.add(item4);
    }

    private void createHamburgarList(ArrayList<Item> foodList) {
        int res;
        res = getResources().getIdentifier("chicken_burger", "drawable", this.getPackageName());
        Item item1 = new Item("Chicken Burger","Crispy chicken with cheese,Tomatoes,Mushrooms, and ransh dressing",11.99,res);

        res = getResources().getIdentifier("beef_burger", "drawable", this.getPackageName());
        Item item2 = new Item("Beef Burger","Breaded and grilled beef chop with tomato, mushrooms and thousand islands sauce",15.99,res);

        res = getResources().getIdentifier("pork_burger", "drawable", this.getPackageName());
        Item item3 = new Item("Pork Burger","Breaded and grilled pork chop with tomato, mushrooms and mayo",19.99,res);

        res = getResources().getIdentifier("fish_burger", "drawable", this.getPackageName());
        Item item4 = new Item("Fish Burger","Fish chop with cheese, mushrooms and mayo",13.99,res);

        res = getResources().getIdentifier("no_meat_burger", "drawable", this.getPackageName());
        Item item5 = new Item("No Meat Burger","Mixed vegetables, tomato, mushrooms, lettuce, and mayo",10.99,res);
        foodList.add(item1);
        foodList.add(item2);
        foodList.add(item3);
        foodList.add(item4);
        foodList.add(item5);
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