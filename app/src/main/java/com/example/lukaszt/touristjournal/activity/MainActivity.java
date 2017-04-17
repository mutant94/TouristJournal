package com.example.lukaszt.touristjournal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lukaszt.touristjournal.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermision();
        Intent intent = new Intent(this, MenuCityActivity.class);
        startActivity(intent);
        finish();
    }

    private void checkPermision() {
        //TODO
    }

}
