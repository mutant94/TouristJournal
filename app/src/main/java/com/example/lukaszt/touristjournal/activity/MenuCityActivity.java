package com.example.lukaszt.touristjournal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lukaszt.touristjournal.R;
import com.example.lukaszt.touristjournal.objects.TouristCity;
import com.example.lukaszt.touristjournal.objects.adapters.AdapterRVCity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuCityActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        //add RecycleView

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_city);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterRVCity(Arrays.asList(TouristCity.values()), this);
        recyclerView.setAdapter(adapter);
    }
}
