package com.example.lukaszt.touristjournal.objects;

import com.example.lukaszt.touristjournal.R;

/**
 * Created by lukaszt on 06.04.2017.
 */

public enum TouristPlace {
    //Bialystok
    BranickiPalace(R.string.Bialystok_name_branicki_palace, R.string.Bialystok_short_description_branicki_palace, R.string.Bialystok_long_description_branicki_palace, R.drawable.branicki_palace, TouristCity.Bialystok, 23.164983333333, 53.130558333333),
    LubomirskiPalace(R.string.Bialystok_name_lubomisrki_palace, R.string.Bialystok__short_description_lubomisrki_palace, R.string.Bialystok__long_description_lubomisrki_palace, R.drawable.lubomirski_palace, TouristCity.Bialystok, 23.204444444444, 53.109444444444),
    HasbachPalace(R.string.Bialystok_name_hasbach_palace, R.string.Bialystok__short_description_hasbach_palace, R.string.Bialystok__long_description_hasbach_palace, R.drawable.hasbach_palace, TouristCity.Bialystok, 23.2025, 53.113611111111),
    BialystokCathedral(R.string.Bialystok_name_cathedral, R.string.Bialystok__short_description_cathedral, R.string.Bialystok__long_description_cathedral, R.drawable.cathedral, TouristCity.Bialystok, 23.162708333333, 53.132511111111),
    //Warsaw
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
