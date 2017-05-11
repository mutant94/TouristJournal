package com.example.lukaszt.touristjournal.objects;

import com.example.lukaszt.touristjournal.R;

/**
 * Created by lukaszt on 06.04.2017.
 */

public enum TouristPlace {
    BranickiPalace(R.string.Bialystok_name_branicki_palace, R.string.Bialystok_short_description_branicki_palace, R.string.Bialystok_long_description_branicki_palace, R.drawable.branicki_palace, TouristCity.Bialystok, 23.164983333333, 53.130558333333),
    RoyalCastle(R.string.Warsaw_name_royal_castle, R.string.Warsaw__short_description_royal_castle, R.string.Warsaw__long_description_royal_castle, R.drawable.royal_castle, TouristCity.Warsaw, 21.014166666667, 52.247777777778);
    public int nameId;
    public int shortDescriptionId;
    public int longDescriptionId;
    public int imageResource;
    public TouristCity city;
    //W, E
    public double longitude;
    //N, S
    public double latitude;

    TouristPlace(int nameId, int shortDescriptionId, int longDescriptionId, int imageResource, TouristCity city, double longitude, double latitude) {
        this.nameId = nameId;
        this.shortDescriptionId = shortDescriptionId;
        this.longDescriptionId = longDescriptionId;
        this.imageResource = imageResource;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
