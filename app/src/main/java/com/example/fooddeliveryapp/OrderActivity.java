package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.fooddeliveryapp.Adapters.OrdersAdapter;
import com.example.fooddeliveryapp.Models.OrdersModel;
import com.example.fooddeliveryapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      DBHelper helper = new DBHelper(this);
      ArrayList<OrdersModel> list = helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.orderRecyclerVIew.setAdapter(adapter);

        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerVIew.setLayoutManager(linearLayoutManager);
    }
}