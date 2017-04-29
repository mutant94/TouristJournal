package com.example.lukaszt.touristjournal.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lukaszt.touristjournal.R;
import com.example.lukaszt.touristjournal.objects.TouristPlace;

public class PlaceInfoActivity extends AppCompatActivity {

    public final static String PLACE_INTENT_KEY = "PLACE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        String placeEnumName = intent.getStringExtra(PLACE_INTENT_KEY);
        TouristPlace touristPlace = TouristPlace.valueOf(placeEnumName);
        TextView titleTV = (TextView) findViewById(R.id.place_info_title);
        TextView textTV = (TextView) findViewById(R.id.place_info_text);
        ImageView imageView = (ImageView) findViewById(R.id.place_info_image);
        titleTV.setText(getResources().getString(touristPlace.nameId));
        textTV.setText(getResources().getString(touristPlace.longDescriptionId));
        imageView.setImageBitmap(Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), touristPlace.imageResource)));
    }
}
