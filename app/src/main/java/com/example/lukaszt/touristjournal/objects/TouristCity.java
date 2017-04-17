package com.example.lukaszt.touristjournal.objects;

import com.example.lukaszt.touristjournal.R;

/**
 * Created by Gamer on 15.04.2017.
 */

public enum TouristCity {
    Bialystok(R.string.Bialystok_name, R.string.Bialystok_desrciption, R.drawable.bialystok),
    Warsaw(R.string.Warsaw_name, R.string.Warsaw_desrciption, R.drawable.warsaw);
    public int nameId;
    public int descriptionId;
    public int imageResource;
    private TouristCity(int nameId, int descriptionId, int imageResource){
        this.nameId = nameId;
        this.descriptionId = descriptionId;
        this.imageResource = imageResource;
    }

}
