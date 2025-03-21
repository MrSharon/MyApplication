package com.shawn.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create hardcoded data
        createItemList();

        // Set up adapter
        adapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }

    private void createItemList() {
        itemList = new ArrayList<>();

        // Add items with descriptions and initial quantities
        itemList.add(new Item(
                "Laptop",
                800.00,
                "Electronics",
                "High-performance laptop with 16GB RAM, 512GB SSD, and a 15.6-inch display.",
                10
        ));

        itemList.add(new Item(
                "T-Shirt",
                20.00,
                "Clothing",
                "100% cotton t-shirt, machine washable, available in multiple colors.",
                25
        ));

        itemList.add(new Item(
                "Smartphone",
                500.00,
                "Electronics",
                "Latest model with 128GB storage, 6.1-inch OLED display, and dual camera system.",
                15
        ));

        itemList.add(new Item(
                "Jeans",
                45.00,
                "Clothing",
                "Classic fit denim jeans with stretch material for comfort and durability.",
                20
        ));

        itemList.add(new Item(
                "Headphones",
                75.00,
                "Electronics",
                "Wireless over-ear headphones with noise cancellation and 20-hour battery life.",
                12
        ));

        itemList.add(new Item(
                "Sweater",
                35.00,
                "Clothing",
                "Warm knit sweater for winter, available in multiple sizes and patterns.",
                18
        ));

        itemList.add(new Item(
                "Tablet",
                350.00,
                "Electronics",
                "10.2-inch tablet with 64GB storage, perfect for entertainment and productivity.",
                8
        ));
    }
}