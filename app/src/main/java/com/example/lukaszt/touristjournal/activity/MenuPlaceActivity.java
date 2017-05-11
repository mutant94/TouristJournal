package com.example.lukaszt.touristjournal.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lukaszt.touristjournal.R;
import com.example.lukaszt.touristjournal.objects.TouristCity;
import com.example.lukaszt.touristjournal.objects.TouristPlace;
import com.example.lukaszt.touristjournal.objects.adapters.AdapterRVPlace;
import com.example.lukaszt.touristjournal.services.Compass;
import com.example.lukaszt.touristjournal.services.GPSLocation;
import com.example.lukaszt.touristjournal.services.Weather;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuPlaceActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Compass compass;
    private Location lastLocation;
    private GoogleApiClient googleApiClient;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public final static String CITY_INTENT_KEY = "city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_place);
        getSupportActionBar().hide();
        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        addRecycleView();
        compass = new Compass(this);
        Weather weather = new Weather(this);
        Intent intent = getIntent();
        String enumName = intent.getStringExtra(CITY_INTENT_KEY);
        TouristCity city = TouristCity.valueOf(enumName);
        weather.execute(weather.getURL(city.latitude, city.longitude));
    }

    @Override
    protected void onStart() {
        if (googleApiClient.isConnected()) {
            googleApiClient.connect();
        }
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        compass.startRegister();
    }

    @Override
    protected void onPause() {
        super.onPause();
        compass.stopRegister();
    }

    protected void addRecycleView() {
        Intent intent = getIntent();
        String enumName = intent.getStringExtra(CITY_INTENT_KEY);
        TouristCity city = TouristCity.valueOf(enumName);
        List<TouristPlace> touristPlaceAllList = Arrays.asList(TouristPlace.values());
        List<TouristPlace> touristPlaceList = new ArrayList<>();
        List<Float> distanceList = new ArrayList<>();
        for (int i = 0; i < touristPlaceAllList.size(); i++) {
            TouristPlace touristPlace = touristPlaceAllList.get(i);
            if (city.equals(touristPlace.city)) {
                touristPlaceList.add(touristPlace);
                checkDistance(touristPlace, distanceList);
            }
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_place);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterRVPlace(touristPlaceList, distanceList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    private void checkDistance(TouristPlace touristPlace, List<Float> distanceList) {
        Location placeLocation = new Location("place");
        placeLocation.setLatitude(touristPlace.latitude);
        placeLocation.setLongitude(touristPlace.longitude);
        if(lastLocation != null){
            GPSLocation.LAST_LOCATION = lastLocation;
            distanceList.add((float) Math.round((lastLocation.distanceTo(placeLocation))));
        }else if(GPSLocation.LAST_LOCATION != null){
            distanceList.add((float) Math.round((GPSLocation.LAST_LOCATION.distanceTo(placeLocation))));
        }else{
            distanceList.add(-1*1.f);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.w("MenuPlaceActivity", "cannot get location");
            Toast.makeText(getApplicationContext(), "location problem" , Toast.LENGTH_SHORT);
            return;
        }
        Log.w("MenuPlaceActivity", "get location");
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        addRecycleView();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.w("MenuPlaceActivity", "connection suspended " + i );
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.w("MenuPlaceActivity", "connection failed");
    }

    public void changeCompass(RotateAnimation rotate){
        ImageView imageView = (ImageView) findViewById(R.id.menu_place_compass);
        imageView.startAnimation(rotate);
    }
}
