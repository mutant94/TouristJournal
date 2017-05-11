package com.example.lukaszt.touristjournal.objects;

import com.example.lukaszt.touristjournal.R;

/**
 * Created by Gamer on 15.04.2017.
 */

public enum TouristCity {
    Bialystok(R.string.Bialystok_name, R.string.Bialystok_desrciption, R.drawable.bialystok, 23.164983333333, 53.130558333333),
    Warsaw(R.string.Warsaw_name, R.string.Warsaw_desrciption, R.drawable.warsaw, 21.014166666667, 52.247777777778);
    public int nameId;
    public int descriptionId;
    public int imageResource;
    public double longitude;
    public double latitude;
    private TouristCity(int nameId, int descriptionId, int imageResource, double longitude, double latitude){
        this.nameId = nameId;
        this.descriptionId = descriptionId;
        this.imageResource = imageResource;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
