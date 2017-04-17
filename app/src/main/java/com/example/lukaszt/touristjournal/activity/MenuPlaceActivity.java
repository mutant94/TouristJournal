package com.example.lukaszt.touristjournal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lukaszt.touristjournal.R;
import com.example.lukaszt.touristjournal.objects.TouristCity;

public class MenuPlaceActivity extends AppCompatActivity {

    public final static String CITY_INTENT_KEY = "city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_place);
        Intent intent = getIntent();
        String enumName = intent.getStringExtra(CITY_INTENT_KEY);
        TouristCity city = TouristCity.valueOf(enumName);
    }
}
