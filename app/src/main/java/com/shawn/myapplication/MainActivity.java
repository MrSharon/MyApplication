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

        // Add at least 5 hardcoded items
        itemList.add(new Item("Laptop", 800.00, "Electronics"));
        itemList.add(new Item("T-Shirt", 20.00, "Clothing"));
        itemList.add(new Item("Smartphone", 500.00, "Electronics"));
        itemList.add(new Item("Jeans", 45.00, "Clothing"));
        itemList.add(new Item("Headphones", 75.00, "Electronics"));
        itemList.add(new Item("Sweater", 35.00, "Clothing"));
        itemList.add(new Item("Tablet", 350.00, "Electronics"));
    }
}